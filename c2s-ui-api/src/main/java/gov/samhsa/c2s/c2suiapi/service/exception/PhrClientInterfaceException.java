package gov.samhsa.c2s.c2suiapi.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class PhrClientInterfaceException extends RuntimeException{
    public PhrClientInterfaceException() {
    }

    public PhrClientInterfaceException(String message) {
        super(message);
    }

    public PhrClientInterfaceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhrClientInterfaceException(Throwable cause) {
        super(cause);
    }

    public PhrClientInterfaceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
