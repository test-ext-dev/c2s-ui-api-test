package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.UmsLookupClient;
import gov.samhsa.c2s.c2suiapi.service.dto.UserCreationLookupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UmsLookupServiceImpl implements UmsLookupService {

    @Autowired
    private UmsLookupClient umsLookupClient;

    @Override
    public UserCreationLookupDto getUserCreationLookupInfo() {
        return UserCreationLookupDto.builder()
                .genderCodes(umsLookupClient.getGenderCodes())
                .stateCodes(umsLookupClient.getStateCodes())
                .countryCodes(umsLookupClient.getCountryCodes())
                .locales(umsLookupClient.getLocales())
                .roles(umsLookupClient.getRoles())
                .identifierSystems(umsLookupClient.getIdentifierSystem())
                .build();
    }
}
