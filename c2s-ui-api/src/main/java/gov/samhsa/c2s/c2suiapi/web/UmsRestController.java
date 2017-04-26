package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ProfileDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserActivationRequestDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserVerificationRequestDto;
import gov.samhsa.c2s.c2suiapi.service.UmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping(value = "/users/activation")
    public Object activateUser(@Valid @RequestBody UserActivationRequestDto userActivationRequest,
                               @RequestHeader(X_FORWARDED_PROTO) String xForwardedProto,
                               @RequestHeader(X_FORWARDED_HOST) String xForwardedHost,
                               @RequestHeader(X_FORWARDED_PORT) int xForwardedPort) {
        return umsService.activateUser(userActivationRequest, xForwardedProto, xForwardedHost, xForwardedPort);
    }

    @GetMapping("/profile")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileDto setProfile() {
        return umsService.getProfile();
    }
}
