package gov.samhsa.c2s.c2suiapi.service;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import feign.FeignException;
import gov.samhsa.c2s.c2suiapi.infrastructure.UmsAvatarClient;
import gov.samhsa.c2s.c2suiapi.service.dto.AvatarBytesAndMetaDto;
import gov.samhsa.c2s.c2suiapi.service.exception.ums.InvalidAvatarInputException;
import gov.samhsa.c2s.c2suiapi.service.exception.ums.UmsClientInterfaceException;
import gov.samhsa.c2s.c2suiapi.service.exception.ums.UserAvatarDeleteException;
import gov.samhsa.c2s.c2suiapi.service.exception.ums.UserAvatarNotFoundException;
import gov.samhsa.c2s.c2suiapi.service.exception.ums.UserAvatarSaveException;
import gov.samhsa.c2s.c2suiapi.service.exception.ums.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

        AvatarBytesAndMetaDto avatarBytesAndMetaDto;

        // TODO: Add check for viruses in file via call to ClamAV antivirus scanner service

        try {
            avatarBytesAndMetaDto = extractAvatarFileBytesAndMeta(avatarFile);
        } catch (IOException e) {
            log.error("An IOException occurred while attempting to extract the file bytes from the uploaded avatar file", e);
            throw new UserAvatarSaveException("An error occurred while attempting to save a new user avatar");
        }

        try {
            return umsAvatarClient.saveNewUserAvatar(userId, avatarBytesAndMetaDto, fileWidthPixels, fileHeightPixels);
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

    @Override
    public void deleteUserAvatar(Long userId) {
        //Assert user ID belongs to current user
        enforceUserAuthService.assertCurrentUserMatchesUserId(userId);

        try {
            umsAvatarClient.deleteUserAvatar(userId);
        } catch (HystrixRuntimeException hystrixErr) {
            Throwable causedBy = hystrixErr.getCause();

            if(!(causedBy instanceof FeignException)){
                log.error("Unexpected instance of HystrixRuntimeException has occurred", hystrixErr);
                throw new UmsClientInterfaceException("An unknown error occurred while attempting to communicate with UMS service");
            }

            int causedByStatus = ((FeignException) causedBy).status();

            switch(causedByStatus){
                case 500:
                    log.error("UMS client returned an Internal Server Error exception while attempting to delete a user's avatar", causedBy);
                    throw new UserAvatarDeleteException("An error occurred while attempting to delete a user's avatar");
                default:
                    log.error("UMS client returned an unexpected instance of FeignException", causedBy);
                    throw new UmsClientInterfaceException("An unknown error occurred while attempting to communicate with UMS service");
            }
        }
    }

    private AvatarBytesAndMetaDto extractAvatarFileBytesAndMeta(MultipartFile avatarFile) throws IOException {
        return AvatarBytesAndMetaDto.builder()
                .fileContents(avatarFile.getBytes())
                .fileSizeBytes(avatarFile.getSize())
                .fileName(avatarFile.getOriginalFilename())
                .fileExtension(extractExtensionFromFileName(avatarFile.getOriginalFilename()))
                .build();
    }

    private String extractExtensionFromFileName(String fileName) {
        int indexOfLastDot = fileName.lastIndexOf(".");

        if (indexOfLastDot < 0) {
            log.error("Unable to extract file extension from file name in object in extractExtensionFromFileName method because the index of the '.' character in the file name string could not be located", fileName);
            throw new InvalidAvatarInputException("Unable to determine the file extension");
        }

        return fileName.substring(indexOfLastDot + 1);
    }
}
