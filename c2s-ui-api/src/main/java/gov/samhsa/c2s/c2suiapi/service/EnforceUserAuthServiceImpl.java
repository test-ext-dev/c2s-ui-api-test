package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.UmsClient;
import gov.samhsa.c2s.c2suiapi.service.dto.JwtTokenKey;
import gov.samhsa.c2s.c2suiapi.service.exception.PatientNotBelongToCurrentUserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EnforceUserAuthServiceImpl implements EnforceUserAuthService {
    private final UmsClient umsClient;
    private final JwtTokenExtractor jwtTokenExtractor;

    @Autowired
    public EnforceUserAuthServiceImpl(UmsClient umsClient, JwtTokenExtractor jwtTokenExtractor) {
        this.umsClient = umsClient;
        this.jwtTokenExtractor = jwtTokenExtractor;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void assertCurrentUserAuthorizedForMrn(String mrn) {
        // Get current user authId
        String userAuthId = jwtTokenExtractor.getValueByKey(JwtTokenKey.USER_ID);

        if (!umsClient.getAccessDecision(userAuthId, mrn).isVerified()) {
            log.warn("A user with the userAuthId of '" + userAuthId + "' attempted to access a patient with the MRN of '" + mrn +"', however this user is not authorized to access that patient's information.");
            throw new PatientNotBelongToCurrentUserException();
        }
    }
}
