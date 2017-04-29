package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.TryPolicyDto;

public interface TryPolicyService {
    /**
     *
     * @param documentId
     * @param consentId
     * @param patientId  A.K.A MRN
     * @param purposeOfUse
     * @return
     */
    TryPolicyDto getSegmentDocXHTML(String documentId, String consentId, String patientId, String purposeOfUse);
}
