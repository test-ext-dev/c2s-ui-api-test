package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.UmsClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.BaseUmsLookupDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UmsUserDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserActivationRequestDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UserVerificationRequestDto;
import gov.samhsa.c2s.c2suiapi.service.dto.ProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class UmsServiceImpl implements UmsService {

    @Autowired
    JwtTokenExtractor jwtTokenExtractor;

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
    public ProfileResponse getProfile(OAuth2Authentication oAuth2Authentication) {
        //Get system supported Locales
        List<String> supportedLocales = umsClient.getLocales().stream()
                .map(BaseUmsLookupDto::getCode)
                .collect(Collectors.toList());
        //Get Current user
        String userAuthId = jwtTokenExtractor.getValueByKey(oAuth2Authentication, JwtTokenExtractor.USER_ID);
        String currentUsername = jwtTokenExtractor.getValueByKey(oAuth2Authentication, JwtTokenExtractor.USER_NAME);
        UmsUserDto currentUser = umsClient.getUserByAuthId(userAuthId);

        return ProfileResponse.builder()
                .userLocale(currentUser.getLocale())
                .supportedLocales(supportedLocales)
                .username(currentUsername)
                .firstName(currentUser.getFirstName())
                .lastName(currentUser.getLastName())
                .mrn(currentUser.getMrn())
                .build();
    }

    @Override
    public boolean getAccessDecision(String userAuthId,String mrn){
        return umsClient.getAccessDecision(userAuthId,mrn);
    }

    @Override
    public void setDefaultLocale(OAuth2Authentication oAuth2Authentication, @RequestHeader("Accept-Language") Locale locale){
        String userAuthId = jwtTokenExtractor.getValueByKey(oAuth2Authentication, JwtTokenExtractor.USER_ID);
        umsClient.updateUserLocaleByUserAuthId(userAuthId, locale);
    }

}
