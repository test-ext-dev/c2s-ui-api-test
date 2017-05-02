package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.TryPolicyClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.TryPolicyDto;
import org.springframework.stereotype.Service;

@Service
public class TryPolicyServiceImpl implements TryPolicyService {
    private final TryPolicyClient tryPolicyClient;

    public TryPolicyServiceImpl(TryPolicyClient tryPolicyClient) {
        this.tryPolicyClient = tryPolicyClient;
    }

    @Override
    public TryPolicyDto getSegmentDocXHTML(String documentId, String consentId, String patientId, String purposeOfUse) {
        return tryPolicyClient.tryPolicyByConsentIdXHTML(documentId, consentId, patientId, purposeOfUse);
    }
}
