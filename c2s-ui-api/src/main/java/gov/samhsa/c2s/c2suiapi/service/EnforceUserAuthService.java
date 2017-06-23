package gov.samhsa.c2s.c2suiapi.service;

public interface EnforceUserAuthService {

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

    /**
     * Enforces only granting access to a user specified by user id if
     * the currently authenticated user matches the specified user id
     * <p>
     * If current user is not the user specified by user id, then a
     * UserUnauthorizedException is thrown, which will trigger an
     * HTTP 403 - FORBIDDEN FAILED status code to be returned
     * to the client.
     * @see gov.samhsa.c2s.c2suiapi.service.exception.UserUnauthorizedException
     *
     * @param userId - the user ID to verify matches the currently authenticated user
     */
    void assertCurrentUserMatchesUserId(Long userId);
}
