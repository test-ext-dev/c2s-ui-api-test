package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.PcmClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.UmsClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.*;
import gov.samhsa.c2s.c2suiapi.service.dto.JwtTokenKey;
import gov.samhsa.c2s.c2suiapi.service.exception.PatientNotBelongToCurrentUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcmServiceImpl implements PcmService {

    private PcmClient pcmClient;

    private UmsClient umsClient;

    private JwtTokenExtractor jwtTokenExtractor;

    @Autowired
    public PcmServiceImpl(PcmClient pcmClient, UmsClient umsClient,
                          JwtTokenExtractor jwtTokenExtractor) {
        this.pcmClient = pcmClient;
        this.umsClient = umsClient;
        this.jwtTokenExtractor = jwtTokenExtractor;
    }

    @Override
    public List<ConsentProviderDto> getProviders(String mrn) {
        //Assert mrn belong to current user
        assertMrnBelongToCurrentUser(mrn);
        return pcmClient.getProviders(mrn);
    }

    @Override
    public void saveProviders(String mrn, IdentifiersDto providerIdentifiersDto) {
        //Assert mrn belong to current user
        assertMrnBelongToCurrentUser(mrn);
        pcmClient.saveProviders(mrn, providerIdentifiersDto);
    }

    @Override
    public void deleteProvider(String mrn, Long providerId) {
        //Assert mrn belong to current user
        assertMrnBelongToCurrentUser(mrn);
        pcmClient.deleteProvider(mrn, providerId);
    }

    @Override
    public Object getConsent(String mrn, Long consentId, String format) {
        //Assert mrn belong to current user
        assertMrnBelongToCurrentUser(mrn);
        return pcmClient.getConsent(mrn, consentId, format);
    }

    @Override
    public Object getAttestedConsent(String mrn, Long consentId, String format) {
        //Assert mrn belong to current user
        assertMrnBelongToCurrentUser(mrn);
        return pcmClient.getAttestedConsent(mrn, consentId, format);
    }

    @Override
    public Object getRevokedConsent(String mrn, Long consentId, String format) {
        //Assert mrn belong to current user
        assertMrnBelongToCurrentUser(mrn);
        return pcmClient.getRevokedConsent(mrn, consentId, format);
    }

    @Override
    public PageableDto<DetailedConsentDto> getConsents(String mrn, Integer page, Integer size) {
        //Assert mrn belong to current user
        assertMrnBelongToCurrentUser(mrn);
        return pcmClient.getConsents(mrn, page, size);
    }

    @Override
    public void saveConsent(String mrn, ConsentDto consentDto) {
        //Assert mrn belong to current user
        assertMrnBelongToCurrentUser(mrn);
        pcmClient.saveConsent(mrn, consentDto);
    }

    @Override
    public void deleteConsent(String mrn, Long consentId) {
        //Assert mrn belong to current user
        assertMrnBelongToCurrentUser(mrn);
        pcmClient.deleteConsent(mrn, consentId);
    }

    @Override
    public void updateConsent(String mrn, Long consentId, ConsentDto consentDto) {
        //Assert mrn belong to current user
        assertMrnBelongToCurrentUser(mrn);
        pcmClient.updateConsent(mrn, consentId, consentDto);
    }

    @Override
    public void attestConsent(String mrn, Long consentId, ConsentAttestationDto consentAttestationDto) {
        //Assert mrn belong to current user
        assertMrnBelongToCurrentUser(mrn);
        pcmClient.attestConsent(mrn, consentId, consentAttestationDto);
    }

    @Override
    public void revokeConsent(String mrn, Long consentId, ConsentRevocationDto consentRevocationDto) {
        //Assert mrn belong to current user
        assertMrnBelongToCurrentUser(mrn);
        pcmClient.revokeConsent(mrn, consentId, consentRevocationDto);
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

    private void assertMrnBelongToCurrentUser(String mrn) {
        // Get current user authId
        String userAuthId = jwtTokenExtractor.getValueByKey(JwtTokenKey.USER_ID);

        if (!umsClient.getAccessDecision(userAuthId, mrn)) {
            throw new PatientNotBelongToCurrentUserException();
        }
    }
}