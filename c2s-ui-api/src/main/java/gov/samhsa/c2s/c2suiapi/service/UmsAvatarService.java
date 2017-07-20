package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.service.dto.AvatarFileInputDto;

public interface UmsAvatarService {
    Object getUserAvatar(Long userId);

    Object saveNewUserAvatar(Long userId, AvatarFileInputDto avatarFile);

    void deleteUserAvatar(Long userId);
}
