package gov.samhsa.c2s.c2suiapi.service;


import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserActivationRequestDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserVerificationRequestDto;
import gov.samhsa.c2s.c2suiapi.service.dto.ProfileResponse;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Locale;

public interface UmsService {
    Object verify(UserVerificationRequestDto userVerificationRequest);

    Object checkDuplicateUsername(String username);

    Object activateUser(UserActivationRequestDto userActivationRequest,
                        String xForwardedProto,
                        String xForwardedHost,
                        int xForwardedPort);

    ProfileResponse getProfile();

    void setDefaultLocale(@RequestHeader("Accept-Language") Locale locale);
}
