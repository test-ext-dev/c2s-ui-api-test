package gov.samhsa.c2s.c2suiapi.service.exception.phr;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class DocumentInvalidException extends RuntimeException {
    public DocumentInvalidException() {}

    public DocumentInvalidException(String message) {
        super(message);
    }
}
