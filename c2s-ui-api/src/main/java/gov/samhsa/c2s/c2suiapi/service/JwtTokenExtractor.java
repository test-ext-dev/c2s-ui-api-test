package gov.samhsa.c2s.c2suiapi.service;

import org.springframework.security.oauth2.provider.OAuth2Authentication;

public interface JwtTokenExtractor {
    final String JTI = "jti";
    final String SUB = "sub";
    final String SCOPE = "scope";
    final String CLIENT_ID = "client_id";
    final String GRANT_TYPE = "grant_type";
    final String USER_ID = "user_id";
    final String ORIGIN = "origin";
    final String USER_NAME = "user_name";
    final String EMAIL = "email";
    final String AUTH_TIME = "auth_time";
    final String EXP = "exp";

    public String getValueByKey(OAuth2Authentication oAuth2Authentication, String key);
}