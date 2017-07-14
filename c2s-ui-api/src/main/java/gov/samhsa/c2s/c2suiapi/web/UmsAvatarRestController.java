package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.service.UmsAvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
                                    @RequestParam(value = "avatarFile") MultipartFile avatarFile,
                                    @RequestParam(value = "fileWidthPixels") Long fileWidthPixels,
                                    @RequestParam(value = "fileHeightPixels") Long fileHeightPixels) {
        return umsAvatarService.saveNewUserAvatar(userId, avatarFile, fileWidthPixels, fileHeightPixels);
    }
}
