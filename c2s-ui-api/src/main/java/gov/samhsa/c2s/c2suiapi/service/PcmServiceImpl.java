package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.PcmClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.*;
import gov.samhsa.c2s.c2suiapi.service.dto.JwtTokenKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class PcmServiceImpl implements PcmService {
    private final PcmClient pcmClient;
    private final EnforceUserAuthService enforceUserAuthService;
    private final JwtTokenExtractor jwtTokenExtractor;

    private static final boolean CREATED_BY_PATIENT = true;
    private static final boolean ATTESTED_BY_PATIENT = true;
    private static final boolean REVOKED_BY_PATIENT = true;

    @Autowired
    public PcmServiceImpl(PcmClient pcmClient, EnforceUserAuthService enforceUserAuthService, JwtTokenExtractor jwtTokenExtractor) {
        this.pcmClient = pcmClient;
        this.enforceUserAuthService = enforceUserAuthService;
        this.jwtTokenExtractor = jwtTokenExtractor;
    }

    @Override
    public List<ConsentProviderDto> getProviders(String mrn) {
        //Assert mrn belong to current user
        enforceUserAuthService.assertCurrentUserAuthorizedForMrn(mrn);
        return pcmClient.getProviders(mrn);
    }

    @Override
    public void saveProviders(String mrn, IdentifiersDto providerIdentifiersDto) {
        //Assert mrn belong to current user
        enforceUserAuthService.assertCurrentUserAuthorizedForMrn(mrn);
        pcmClient.saveProviders(mrn, providerIdentifiersDto);
    }

    @Override
    public void deleteProvider(String mrn, Long providerId) {
        //Assert mrn belong to current user
        enforceUserAuthService.assertCurrentUserAuthorizedForMrn(mrn);
        pcmClient.deleteProvider(mrn, providerId);
    }

    @Override
    public Object getConsent(String mrn, Long consentId, String format) {
        //Assert mrn belong to current user
        enforceUserAuthService.assertCurrentUserAuthorizedForMrn(mrn);
        return pcmClient.getConsent(mrn, consentId, format);
    }

    @Override
    public Object getAttestedConsent(String mrn, Long consentId, String format) {
        //Assert mrn belong to current user
        enforceUserAuthService.assertCurrentUserAuthorizedForMrn(mrn);
        return pcmClient.getAttestedConsent(mrn, consentId, format);
    }

    @Override
    public Object getRevokedConsent(String mrn, Long consentId, String format) {
        //Assert mrn belong to current user
        enforceUserAuthService.assertCurrentUserAuthorizedForMrn(mrn);
        return pcmClient.getRevokedConsent(mrn, consentId, format);
    }

    @Override
    public PageableDto<DetailedConsentDto> getConsents(String mrn, Integer page, Integer size) {
        //Assert mrn belong to current user
        enforceUserAuthService.assertCurrentUserAuthorizedForMrn(mrn);
        return pcmClient.getConsents(mrn, page, size);
    }

    @Override
    public void saveConsent(String mrn, ConsentDto consentDto, Locale locale) {
        //Assert mrn belong to current user
        enforceUserAuthService.assertCurrentUserAuthorizedForMrn(mrn);

        // Get current user authId
        String createdBy = jwtTokenExtractor.getValueByKey(JwtTokenKey.USER_ID);
        pcmClient.saveConsent(mrn, consentDto, locale, createdBy, CREATED_BY_PATIENT);
    }

    @Override
    public void deleteConsent(String mrn, Long consentId) {
        //Assert mrn belong to current user
        enforceUserAuthService.assertCurrentUserAuthorizedForMrn(mrn);

        // Get current user authId
        String lastUpdatedBy = jwtTokenExtractor.getValueByKey(JwtTokenKey.USER_ID);
        pcmClient.deleteConsent(mrn, consentId, lastUpdatedBy);
    }

    @Override
    public void updateConsent(String mrn, Long consentId, ConsentDto consentDto) {
        //Assert mrn belong to current user
        enforceUserAuthService.assertCurrentUserAuthorizedForMrn(mrn);

        // Get current user authId
        String lastUpdatedBy = jwtTokenExtractor.getValueByKey(JwtTokenKey.USER_ID);
        pcmClient.updateConsent(mrn, consentId, consentDto, lastUpdatedBy);
    }

    @Override
    public void attestConsent(String mrn, Long consentId, ConsentAttestationDto consentAttestationDto) {
        //Assert mrn belong to current user
        enforceUserAuthService.assertCurrentUserAuthorizedForMrn(mrn);

        // Get current user authId
        String attestedBy = jwtTokenExtractor.getValueByKey(JwtTokenKey.USER_ID);
        pcmClient.attestConsent(mrn, consentId, consentAttestationDto, attestedBy, ATTESTED_BY_PATIENT);
    }

    @Override
    public void revokeConsent(String mrn, Long consentId, ConsentRevocationDto consentRevocationDto) {
        //Assert mrn belong to current user
        enforceUserAuthService.assertCurrentUserAuthorizedForMrn(mrn);

        // Get current user authId
        String revokedBy = jwtTokenExtractor.getValueByKey(JwtTokenKey.USER_ID);
        pcmClient.revokeConsent(mrn, consentId, consentRevocationDto, revokedBy, REVOKED_BY_PATIENT);
    }

    @Override
    public List<PurposeDto> getPurposes() {
        return pcmClient.getPurposes();
    }

    @Override
    public ConsentTermDto getConsentAttestationTerm(Long id, Locale locale) {
        return pcmClient.getConsentAttestationTerm(id, locale);
    }

    @Override
    public ConsentTermDto getConsentRevocationTerm(Long id, Locale locale) {
        return pcmClient.getConsentRevocationTerm(id, locale);
    }

    @Override
    public ConsentTypeConfigurationDto getConsentTypeConfiguration() {
        return pcmClient.getConsentTypeConfiguration();
    }
}