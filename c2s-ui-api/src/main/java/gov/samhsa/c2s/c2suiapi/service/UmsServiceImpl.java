package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.config.UmsProperties;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UmsServiceImpl implements UmsService{

    @Autowired
    private UmsProperties umsProperties;

    @Override
    public ProfileDto getProfile() {
        ProfileDto profile =  new ProfileDto();
        profile.setDefaultLocale(umsProperties.getDefaultLocale());
        profile.setLocales(umsProperties.getSupportedLocales());
        return profile;
    }
}
