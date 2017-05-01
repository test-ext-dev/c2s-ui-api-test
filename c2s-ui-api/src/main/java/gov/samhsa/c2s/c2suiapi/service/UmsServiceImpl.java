package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.config.UmsProperties;
import gov.samhsa.c2s.c2suiapi.infrastructure.UmsClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ProfileDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserActivationRequestDto;
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
    public Object checkDuplicateUsername(String username) {
        return umsClient.checkDuplicateUsername(username);
    }

    @Override
    public Object activateUser(UserActivationRequestDto userActivationRequest, String xForwardedProto, String xForwardedHost, int xForwardedPort) {
        return umsClient.activateUser(userActivationRequest, xForwardedProto, xForwardedHost, xForwardedPort);
    }

    @Override
    public ProfileDto getProfile() {
        ProfileDto profile = new ProfileDto();
        profile.setDefaultLocale(umsProperties.getDefaultLocale());
        profile.setLocales(umsProperties.getSupportedLocales());
        return profile;
    }

    @Override
    public boolean getAccessDecision(String userAuthId,String mrn){
        return umsClient.getAccessDecision(userAuthId,mrn);
    }
}
