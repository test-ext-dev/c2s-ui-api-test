package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.service.dto.JwtTokenKey;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

public interface JwtTokenExtractor {
    String getValueByKey(OAuth2Authentication oAuth2Authentication, JwtTokenKey key);
}