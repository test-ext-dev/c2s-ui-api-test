package gov.samhsa.c2s.c2suiapi.service;

import org.springframework.security.oauth2.provider.OAuth2Authentication;

public interface JwtTokenExtractor  {
    public String getValueByKey(OAuth2Authentication oAuth2Authentication, String key);
}