package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.service.UmsAvatarService;
import gov.samhsa.c2s.c2suiapi.service.dto.AvatarFileInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ums")
public class UmsAvatarRestController {
    private final UmsAvatarService umsAvatarService;

    @Autowired
    public UmsAvatarRestController(UmsAvatarService umsAvatarService) {
        this.umsAvatarService = umsAvatarService;
    }

    @GetMapping(value = "/user-avatars/user/{userId}/avatar")
    public Object getUserAvatar(@PathVariable("userId") Long userId) {
        return umsAvatarService.getUserAvatar(userId);
    }

    @PostMapping(value = "/user-avatars/user/{userId}/avatar")
    public Object saveNewUserAvatar(@PathVariable("userId") Long userId,
                                    @RequestBody AvatarFileInputDto avatarFile) {
        return umsAvatarService.saveNewUserAvatar(userId, avatarFile);
    }

    @DeleteMapping(value = "/user-avatars/user/{userId}/avatar")
    public void deleteUserAvatar(@PathVariable("userId") Long userId) {
        umsAvatarService.deleteUserAvatar(userId);
    }
}
