package gov.samhsa.c2s.c2suiapi.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoDocumentsFoundException extends RuntimeException {
    public NoDocumentsFoundException() {
    }

    public NoDocumentsFoundException(String message) {
        super(message);
    }
}