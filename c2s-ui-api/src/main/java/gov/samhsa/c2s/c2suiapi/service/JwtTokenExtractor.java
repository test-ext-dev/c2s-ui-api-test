package gov.samhsa.c2s.c2suiapi.service;

import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.common.util.JsonParser;
import org.springframework.security.oauth2.common.util.JsonParserFactory;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JwtTokenExtractor  {
    public String getValueByKey(OAuth2AuthenticationDetails oAuth2AuthenticationDetails, String key){
       JsonParser objectMapper = JsonParserFactory.create();
       Jwt jwt = JwtHelper.decode(oAuth2AuthenticationDetails.getTokenValue());
       String content = jwt.getClaims();
       Map<String,Object> map = objectMapper.parseMap(jwt.getClaims());
       return (String)map.get(key);
    }
}