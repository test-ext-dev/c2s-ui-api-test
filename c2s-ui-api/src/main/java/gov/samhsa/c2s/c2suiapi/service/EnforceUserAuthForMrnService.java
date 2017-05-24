package gov.samhsa.c2s.c2suiapi.service;

public interface EnforceUserAuthForMrnService {

    /**
     * Enforces only granting access to users who are authorized
     * to access a particular patient's MRN
     * <p>
     * If current user is not authorized to access the specified patient MRN,
     * then a PatientNotBelongToCurrentUserException is throw, which will
     * trigger an HTTP 412 - PRECONDITION FAILED status code to be returned
     * to the client.
     * @see gov.samhsa.c2s.c2suiapi.service.exception.PatientNotBelongToCurrentUserException
     *
     * @param mrn - the patient MRN to verify the current user is permitted to access
     */
    void assertCurrentUserAuthorizedForMrn(String mrn);
}
