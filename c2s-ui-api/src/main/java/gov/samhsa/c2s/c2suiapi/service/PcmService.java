package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.PcmFlattenedSmallProviderDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.IdentifiersDto;

import java.util.List;

public interface PcmService {
    List<PcmFlattenedSmallProviderDto> getProviders();

    void saveProviders(IdentifiersDto providerIdentifiersDto);

    void deleteProvider(Long providerId);
}