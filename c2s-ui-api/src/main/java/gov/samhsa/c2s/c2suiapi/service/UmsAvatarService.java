package gov.samhsa.c2s.c2suiapi.service;

import org.springframework.web.multipart.MultipartFile;

public interface UmsAvatarService {
    Object getUserAvatar(Long userId);

    Object saveNewUserAvatar(Long userId, MultipartFile avatarFile, Long fileWidthPixels, Long fileHeightPixels);

    void deleteUserAvatar(Long userId);
}
