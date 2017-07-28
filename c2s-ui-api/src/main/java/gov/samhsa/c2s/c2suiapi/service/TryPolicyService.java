package gov.samhsa.c2s.c2suiapi.service;

public interface TryPolicyService {
    /**
     * @param documentId   **The Patient's medical Document ID**
     * @param consentId    **The Patient's consent ID**
     * @param patientId    **The Patient's ID **
     * @param purposeOfUse **The Purpose Of Use for which the Try-Policy is being applied**
     * @return **Try-Policy response in XHTML**
     */
    Object getSegmentDocXHTML(String patientId, String consentId, String documentId, String purposeOfUse);
}
