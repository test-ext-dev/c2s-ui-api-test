package gov.samhsa.c2s.c2suiapi.infrastructure;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.BaseUmsLookupDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UmsUserDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserActivationRequestDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserVerificationRequestDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient("ums")
public interface UmsClient {
    public static final String X_FORWARDED_PROTO = "X-Forwarded-Proto";
    public static final String X_FORWARDED_HOST = "X-Forwarded-Host";
    public static final String X_FORWARDED_PORT = "X-Forwarded-Port";

    @RequestMapping(value = "/users/verification", method = RequestMethod.POST)
    Object verify(@Valid @RequestBody UserVerificationRequestDto userVerificationRequest);

    @RequestMapping(value = "/users/activation", method = RequestMethod.GET)
    Object checkDuplicateUsername(@RequestParam("username") String username);

    @RequestMapping(value = "/users/activation", method = RequestMethod.POST)
    Object activateUser(@Valid @RequestBody UserActivationRequestDto userActivationRequest,
                        @RequestHeader(X_FORWARDED_PROTO) String xForwardedProto,
                        @RequestHeader(X_FORWARDED_HOST) String xForwardedHost,
                        @RequestHeader(X_FORWARDED_PORT) int xForwardedPort);

    @RequestMapping(value = "/locales", method = RequestMethod.GET)
    List<BaseUmsLookupDto> getLocales();

    @RequestMapping(value = "/users/authId/{userAuthId}", method = RequestMethod.GET)
    UmsUserDto getUserByAuthId(@RequestParam("userAuthId") String userAuthId);
}