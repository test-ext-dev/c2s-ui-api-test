package gov.samhsa.c2s.c2suiapi.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class PatientNotBelongToCurrentUserException extends RuntimeException {
    public PatientNotBelongToCurrentUserException() {
        super();
    }

    public PatientNotBelongToCurrentUserException(String message) {
        super(message);
    }
}
