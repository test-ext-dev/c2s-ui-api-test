package gov.samhsa.c2s.c2suiapi.service;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import feign.FeignException;
import gov.samhsa.c2s.c2suiapi.infrastructure.UmsAvatarClient;
import gov.samhsa.c2s.c2suiapi.service.exception.ums.InvalidAvatarInputException;
import gov.samhsa.c2s.c2suiapi.service.exception.ums.UmsClientInterfaceException;
import gov.samhsa.c2s.c2suiapi.service.exception.ums.UserAvatarNotFoundException;
import gov.samhsa.c2s.c2suiapi.service.exception.ums.UserAvatarSaveException;
import gov.samhsa.c2s.c2suiapi.service.exception.ums.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class UmsAvatarServiceImpl implements UmsAvatarService {
    private final EnforceUserAuthService enforceUserAuthService;
    private final UmsAvatarClient umsAvatarClient;

    @Autowired
    public UmsAvatarServiceImpl(EnforceUserAuthService enforceUserAuthService, UmsAvatarClient umsAvatarClient) {
        this.enforceUserAuthService = enforceUserAuthService;
        this.umsAvatarClient = umsAvatarClient;
    }

    @Override
    public Object getUserAvatar(Long userId) {
        //Assert user ID belongs to current user
        enforceUserAuthService.assertCurrentUserMatchesUserId(userId);

        try {
            return umsAvatarClient.getUserAvatar(userId);
        } catch (HystrixRuntimeException hystrixErr) {
            Throwable causedBy = hystrixErr.getCause();

            if(!(causedBy instanceof FeignException)){
                log.error("Unexpected instance of HystrixRuntimeException has occurred", hystrixErr);
                throw new UmsClientInterfaceException("An unknown error occurred while attempting to communicate with UMS service");
            }

            int causedByStatus = ((FeignException) causedBy).status();

            switch(causedByStatus){
                case 404:
                    log.info("No avatar was found for the user specified by user ID in the request", causedBy);
                    throw new UserAvatarNotFoundException("The specified user does not have an avatar");
                default:
                    log.error("UMS client returned an unexpected instance of FeignException", causedBy);
                    throw new UmsClientInterfaceException("An unknown error occurred while attempting to communicate with UMS service");
            }
        }
    }

    @Override
    public Object saveNewUserAvatar(Long userId, MultipartFile avatarFile, Long fileWidthPixels, Long fileHeightPixels) {
        //Assert user ID belongs to current user
        enforceUserAuthService.assertCurrentUserMatchesUserId(userId);

        try {
            return umsAvatarClient.saveNewUserAvatar(userId, avatarFile, fileWidthPixels, fileHeightPixels);
        } catch (HystrixRuntimeException hystrixErr) {
            Throwable causedBy = hystrixErr.getCause();

            if(!(causedBy instanceof FeignException)){
                log.error("Unexpected instance of HystrixRuntimeException has occurred", hystrixErr);
                throw new UmsClientInterfaceException("An unknown error occurred while attempting to communicate with UMS service");
            }

            int causedByStatus = ((FeignException) causedBy).status();

            switch(causedByStatus){
                case 400:
                    log.error("Unable to save the avatar file because one or more request parameter values were invalid", causedBy);
                    throw new InvalidAvatarInputException(causedBy.getMessage());
                case 404:
                    log.error("Unable to find a user matching the user ID specified in the request", causedBy);
                    throw new UserNotFoundException("Unable to find the specified user");
                case 500:
                    log.error("An error occurred while attempting to save a new user avatar", causedBy);
                    throw new UserAvatarSaveException("An error occurred while attempting to save a new user avatar");
                default:
                    log.error("UMS client returned an unexpected instance of FeignException", causedBy);
                    throw new UmsClientInterfaceException("An unknown error occurred while attempting to communicate with UMS service");
            }
        }
    }
}
