package gov.samhsa.c2s.c2suiapi.service;


import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ProfileDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserActivationRequestDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserVerificationRequestDto;

public interface UmsService {
    Object verify(UserVerificationRequestDto userVerificationRequest);

    Object checkDuplicateUsername(String username);

    Object activateUser(UserActivationRequestDto userActivationRequest,
                        String xForwardedProto,
                        String xForwardedHost,
                        int xForwardedPort);

    ProfileDto getProfile();
}
