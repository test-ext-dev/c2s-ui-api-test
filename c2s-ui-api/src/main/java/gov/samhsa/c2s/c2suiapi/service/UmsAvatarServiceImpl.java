package gov.samhsa.c2s.c2suiapi.service;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import feign.FeignException;
import gov.samhsa.c2s.c2suiapi.infrastructure.UmsAvatarClient;
import gov.samhsa.c2s.c2suiapi.service.exception.ums.UmsClientInterfaceException;
import gov.samhsa.c2s.c2suiapi.service.exception.ums.UserAvatarNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
