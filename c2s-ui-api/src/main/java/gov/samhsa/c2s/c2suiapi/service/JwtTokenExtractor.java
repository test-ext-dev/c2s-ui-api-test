package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.service.dto.JwtTokenKey;

public interface JwtTokenExtractor {
    String getValueByKey(JwtTokenKey key);
}