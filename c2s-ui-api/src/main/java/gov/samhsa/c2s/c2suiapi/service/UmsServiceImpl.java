package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.config.UmsProperties;
import gov.samhsa.c2s.c2suiapi.infrastructure.UmsClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ProfileDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserVerificationRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UmsServiceImpl implements UmsService {

    @Autowired
    private UmsProperties umsProperties;

    @Autowired
    private UmsClient umsClient;

    @Override
    public Object verify(UserVerificationRequestDto userVerificationRequest) {
        return umsClient.verify(userVerificationRequest);
    }

    @Override
    public ProfileDto getProfile() {
        ProfileDto profile = new ProfileDto();
        profile.setDefaultLocale(umsProperties.getDefaultLocale());
        profile.setLocales(umsProperties.getSupportedLocales());
        return profile;
    }
}
