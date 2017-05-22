package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.TryPolicyClient;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class TryPolicyServiceImpl implements TryPolicyService {
    private final TryPolicyClient tryPolicyClient;

    public TryPolicyServiceImpl(TryPolicyClient tryPolicyClient) {
        this.tryPolicyClient = tryPolicyClient;
    }

    @Override
    public Object getSegmentDocXHTML(String documentId, String consentId, String patientId, String purposeOfUse, Locale locale) {
          return tryPolicyClient.tryPolicyByConsentIdXHTML(documentId, consentId, patientId, purposeOfUse, locale);
    }
}
