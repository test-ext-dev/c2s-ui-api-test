package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserActivationRequestDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserVerificationRequestDto;
import gov.samhsa.c2s.c2suiapi.service.UmsServiceImpl;
import gov.samhsa.c2s.c2suiapi.service.dto.ProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static gov.samhsa.c2s.c2suiapi.infrastructure.UmsClient.*;

@RestController
@RequestMapping("/ums")
public class UmsRestController {

    @Autowired
    private UmsServiceImpl umsService;

    @PostMapping(value = "/users/verification")
    public Object verify(@Valid @RequestBody UserVerificationRequestDto userVerificationRequest) {
        return umsService.verify(userVerificationRequest);
    }

    @GetMapping(value = "/users/activation")
    public Object checkDuplicateUsername(@RequestParam String username) {
        return umsService.checkDuplicateUsername(username);
    }

    @PostMapping(value = "/users/activation")
    public Object activateUser(@Valid @RequestBody UserActivationRequestDto userActivationRequest,
                               @RequestHeader(X_FORWARDED_PROTO) String xForwardedProto,
                               @RequestHeader(X_FORWARDED_HOST) String xForwardedHost,
                               @RequestHeader(X_FORWARDED_PORT) int xForwardedPort) {
        return umsService.activateUser(userActivationRequest, xForwardedProto, xForwardedHost, xForwardedPort);
    }

    @GetMapping("/users/profile")
    public ProfileResponse getProfile(OAuth2Authentication oAuth2Authentication) {
        return umsService.getProfile(oAuth2Authentication);
    }
}
