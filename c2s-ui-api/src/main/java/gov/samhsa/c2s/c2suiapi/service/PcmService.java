package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.FlattenedSmallProviderDto;

import java.util.List;

public interface PcmService {
    List<FlattenedSmallProviderDto> getProviders();
}
