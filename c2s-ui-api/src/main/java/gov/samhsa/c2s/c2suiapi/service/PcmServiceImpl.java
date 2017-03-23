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
    public List<FlattenedSmallProviderDto> getProviders() {
        Long patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        return pcmClient.getProviders(patientId);
    }

    @Override
    public void saveProviders(IdentifiersDto providerIdentifiersDto) {
        Long patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.saveProviders(patientId, providerIdentifiersDto);
    }

    @Override
    public void deleteProvider(Long providerId) {
        Long patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.deleteProvider(patientId, providerId);
    }

    @Override
    public DetailedConsentPageableDto getConsents(Integer page, Integer size) {
        Long patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        return pcmClient.getConsents(patientId, page, size);
    }

    @Override
    public void saveConsent(ConsentDto consentDto) {
        Long patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.saveConsent(patientId, consentDto);
    }

    @Override
    public void deleteConsent(Long consentId) {
        Long patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.deleteConsent(patientId, consentId);
    }

    @Override
    public void updateConsent(Long consentId, ConsentDto consentDto) {
        Long patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.updateConsent(patientId, consentId, consentDto);
    }

    @Override
    public void attestConsent(Long consentId, ConsentAttestationDto consentAttestationDto) {
        Long patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.attestConsent(patientId, consentId, consentAttestationDto);
    }

    @Override
    public void revokeConsent(Long consentId, ConsentRevocationDto consentRevocationDto) {
        Long patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.revokeConsent(patientId, consentId, consentRevocationDto);
    }

    @Override
    public List<PurposeDto> getPurposes() {
        return pcmClient.getPurposes();
    }
}