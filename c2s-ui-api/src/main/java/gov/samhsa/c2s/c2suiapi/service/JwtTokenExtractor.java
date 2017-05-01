package gov.samhsa.c2s.c2suiapi.service;

import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public interface JwtTokenExtractor  {
    public String getValueByKey(OAuth2AuthenticationDetails oAuth2AuthenticationDetails, String key);
}