package gov.samhsa.c2s.c2suiapi.service.exception.phr;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class DocumentDeleteException extends RuntimeException {
    public DocumentDeleteException() {}

    public DocumentDeleteException(String message) {
        super(message);
    }
}
