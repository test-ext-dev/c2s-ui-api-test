package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.*;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Locale;

public interface PcmService {
    List<ConsentProviderDto> getProviders();

    void saveProviders(IdentifiersDto providerIdentifiersDto);

    void deleteProvider(Long providerId);

    Object getConsent(Long consentId, String format);

    Object getAttestedConsent(Long consentId, String format);

    Object getRevokedConsent(Long consentId, String format);

    PageableDto<DetailedConsentDto> getConsents(Integer page, Integer size);

    void saveConsent(ConsentDto consentDto);

    void deleteConsent(Long consentId);

    void updateConsent(Long consentId, ConsentDto consentDto);

    void attestConsent(Long consentId, ConsentAttestationDto consentAttestationDto);

    void revokeConsent(Long consentId, ConsentRevocationDto consentRevocationDto);

    List<PurposeDto> getPurposes(@RequestHeader("Accept-Language") Locale locale);

    ConsentTermDto getConsentAttestationTerm(Long id, @RequestHeader("Accept-Language") Locale locale);

    ConsentTermDto getConsentRevocationTerm(Long id, @RequestHeader("Accept-Language") Locale locale);
}