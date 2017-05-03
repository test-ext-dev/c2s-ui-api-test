package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.*;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Locale;

public interface PcmService {
    List<ConsentProviderDto> getProviders(String mrn);

    void saveProviders(String mrn, IdentifiersDto providerIdentifiersDto);

    void deleteProvider(String mrn, Long providerId);

    Object getConsent(String mrn, Long consentId, String format);

    Object getAttestedConsent(String mrn, Long consentId, String format);

    Object getRevokedConsent(String mrn, Long consentId, String format);

    PageableDto<DetailedConsentDto> getConsents(String mrn, Integer page, Integer size);

    void saveConsent(String mrn, ConsentDto consentDto, Locale locale);

    void deleteConsent(String mrn, Long consentId);

    void updateConsent(String mrn, Long consentId, ConsentDto consentDto);

    void attestConsent(String mrn, Long consentId, ConsentAttestationDto consentAttestationDto);

    void revokeConsent(String mrn, Long consentId, ConsentRevocationDto consentRevocationDto);

    List<PurposeDto> getPurposes(@RequestHeader("Accept-Language") Locale locale);

    ConsentTermDto getConsentAttestationTerm(Long id, @RequestHeader("Accept-Language") Locale locale);

    ConsentTermDto getConsentRevocationTerm(Long id, @RequestHeader("Accept-Language") Locale locale);
}