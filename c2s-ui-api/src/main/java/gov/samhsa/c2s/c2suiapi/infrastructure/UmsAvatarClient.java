package gov.samhsa.c2s.c2suiapi.infrastructure;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "ums")
@Service
public interface UmsAvatarClient {
    @RequestMapping(value = "/user-avatars/user/{userId}/avatar", method = RequestMethod.GET)
    Object getUserAvatar(@PathVariable("userId") Long userId);
}
