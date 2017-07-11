package gov.samhsa.c2s.c2suiapi.infrastructure;

import feign.Headers;
import feign.Param;
import gov.samhsa.c2s.c2suiapi.config.multipartSupport.MultipartSupportConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "ums", configuration = MultipartSupportConfig.class)
@Service
public interface UmsAvatarClient {
    @RequestMapping(value = "/user-avatars/user/{userId}/avatar", method = RequestMethod.GET)
    Object getUserAvatar(@PathVariable("userId") Long userId);

    @RequestMapping(value = "/user-avatars/user/{userId}/avatar", method = RequestMethod.POST)
    @Headers("Content-Type: multipart/form-data")
    Object saveNewUserAvatar(@PathVariable("userId") Long userId,
                             @Param(value = "avatarFile") MultipartFile avatarFile,
                             @RequestParam(value = "fileWidthPixels") Long fileWidthPixels,
                             @RequestParam(value = "fileHeightPixels") Long fileHeightPixels);
}
