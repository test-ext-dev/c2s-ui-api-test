package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.UmsClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.BaseUmsLookupDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UmsUserDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserActivationRequestDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserVerificationRequestDto;
import gov.samhsa.c2s.c2suiapi.service.dto.JwtTokenKey;
import gov.samhsa.c2s.c2suiapi.service.dto.ProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Locale;

@Service
public class UmsServiceImpl implements UmsService {

    private final JwtTokenExtractor jwtTokenExtractor;

    private final UmsClient umsClient;

    @Autowired
    public UmsServiceImpl(JwtTokenExtractor jwtTokenExtractor, UmsClient umsClient) {
        this.jwtTokenExtractor = jwtTokenExtractor;
        this.umsClient = umsClient;
    }

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
    public ProfileResponse getProfile() {
        //Get system supported Locales
        List<BaseUmsLookupDto> supportedLocales = umsClient.getLocales();
        //Get Current user
        String userAuthId = jwtTokenExtractor.getValueByKey(JwtTokenKey.USER_ID);
        String currentUsername = jwtTokenExtractor.getValueByKey(JwtTokenKey.USER_NAME);
        UmsUserDto currentUser = umsClient.getUserByAuthId(userAuthId);

        return ProfileResponse.builder()
                .userLocale(currentUser.getLocale())
                .supportedLocales(supportedLocales)
                .username(currentUsername)
                .firstName(currentUser.getFirstName())
                .lastName(currentUser.getLastName())
                .birthDate(currentUser.getBirthDate())
                .mrn(currentUser.getMrn())
                .build();
    }

    public void setDefaultLocale(@RequestHeader("Accept-Language") Locale locale) {
        String userAuthId = jwtTokenExtractor.getValueByKey(JwtTokenKey.USER_ID);
        umsClient.updateUserLocaleByUserAuthId(userAuthId, locale);
    }
}
