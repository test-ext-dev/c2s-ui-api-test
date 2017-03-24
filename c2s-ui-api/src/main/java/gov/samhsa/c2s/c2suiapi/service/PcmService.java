package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ConsentAttestationDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ConsentDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ConsentProviderDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ConsentRevocationDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.DetailedConsentDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.IdentifiersDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.PageableDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.PurposeDto;

import java.util.List;

public interface PcmService {
    List<ConsentProviderDto> getProviders();

    void saveProviders(IdentifiersDto providerIdentifiersDto);

    void deleteProvider(Long providerId);

    Object getConsent(Long consentId, String format);

    PageableDto<DetailedConsentDto> getConsents(Integer page, Integer size);

    void saveConsent(ConsentDto consentDto);

    void deleteConsent(Long consentId);

    void updateConsent(Long consentId, ConsentDto consentDto);

    void attestConsent(Long consentId, ConsentAttestationDto consentAttestationDto);

    void revokeConsent(Long consentId, ConsentRevocationDto consentRevocationDto);

    List<PurposeDto> getPurposes();
}