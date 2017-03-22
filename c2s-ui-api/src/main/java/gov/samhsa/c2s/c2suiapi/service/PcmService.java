package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.*;

import java.util.List;

public interface PcmService {
    List<FlattenedSmallProviderDto> getProviders();

    void saveProviders(IdentifiersDto providerIdentifiersDto);

    void deleteProvider(Long providerId);

    void saveConsent(ConsentDto consentDto);

    void deleteConsent(Long consentId);

    void updateConsent(Long consentId, ConsentDto consentDto);

    void attestConsent(Long consentId, ConsentAttestationDto consentAttestationDto);

    void revokeConsent(Long consentId, ConsentRevocationDto consentRevocationDto);

    List<PurposeDto> getPurposes();
}