package gov.samhsa.c2s.c2suiapi.service;


import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserActivationRequestDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserVerificationRequestDto;
import gov.samhsa.c2s.c2suiapi.service.dto.ProfileResponse;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

public interface UmsService {
    Object verify(UserVerificationRequestDto userVerificationRequest);

    Object checkDuplicateUsername(String username);

    Object activateUser(UserActivationRequestDto userActivationRequest,
                        String xForwardedProto,
                        String xForwardedHost,
                        int xForwardedPort);

    ProfileResponse getProfile(OAuth2Authentication oAuth2Authentication);

    boolean getAccessDecision(String userAuthId,String mrn);
}
