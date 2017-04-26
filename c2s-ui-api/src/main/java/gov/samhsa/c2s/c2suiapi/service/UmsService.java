package gov.samhsa.c2s.c2suiapi.service;


import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ProfileDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserVerificationRequestDto;

public interface UmsService {
    Object verify(UserVerificationRequestDto userVerificationRequest);

    ProfileDto getProfile();
}
