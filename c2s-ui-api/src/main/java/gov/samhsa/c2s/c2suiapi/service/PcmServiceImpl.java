package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.PatientUserClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.PcmClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcmServiceImpl implements PcmService {
    private static final Long USER_ID = 3L;

    private final PatientUserClient patientUserClient;

    private final PcmClient pcmClient;

    @Autowired
    public PcmServiceImpl(PatientUserClient patientUserClient, PcmClient pcmClient) {
        this.patientUserClient = patientUserClient;
        this.pcmClient = pcmClient;
    }

    @Override
    public List<ConsentProviderDto> getProviders() {
        String patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        return pcmClient.getProviders(patientId);
    }

    @Override
    public void saveProviders(IdentifiersDto providerIdentifiersDto) {
        String patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.saveProviders(patientId, providerIdentifiersDto);
    }

    @Override
    public void deleteProvider(Long providerId) {
        String patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.deleteProvider(patientId, providerId);
    }

    @Override
    public Object getConsent(Long consentId, String format) {
        String patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        return pcmClient.getConsent(patientId, consentId, format);
    }

    @Override
    public Object getAttestedConsent(Long consentId, String format) {
        String patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        return pcmClient.getAttestedConsent(patientId, consentId, format);
    }

    @Override
    public Object getRevokedConsent(Long consentId, String format) {
        String patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        return pcmClient.getRevokedConsent(patientId, consentId, format);
    }

    @Override
    public PageableDto<DetailedConsentDto> getConsents(Integer page, Integer size) {
        String patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        return pcmClient.getConsents(patientId, page, size);
    }

    @Override
    public void saveConsent(ConsentDto consentDto) {
        String patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.saveConsent(patientId, consentDto);
    }

    @Override
    public void deleteConsent(Long consentId) {
        String patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.deleteConsent(patientId, consentId);
    }

    @Override
    public void updateConsent(Long consentId, ConsentDto consentDto) {
        String patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.updateConsent(patientId, consentId, consentDto);
    }

    @Override
    public void attestConsent(Long consentId, ConsentAttestationDto consentAttestationDto) {
        String patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.attestConsent(patientId, consentId, consentAttestationDto);
    }

    @Override
    public void revokeConsent(Long consentId, ConsentRevocationDto consentRevocationDto) {
        String patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.revokeConsent(patientId, consentId, consentRevocationDto);
    }

    @Override
    public List<PurposeDto> getPurposes() {
        return pcmClient.getPurposes();
    }

    @Override
    public ConsentTermDto getConsentAttestationTerm(Long id) {
        return pcmClient.getConsentAttestationTerm(id);
    }

    @Override
    public ConsentTermDto getConsentRevocationTerm(Long id) {
        return pcmClient.getConsentRevocationTerm(id);
    }
}