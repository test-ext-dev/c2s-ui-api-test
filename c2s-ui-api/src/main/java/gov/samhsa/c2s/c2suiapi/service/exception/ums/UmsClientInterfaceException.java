package gov.samhsa.c2s.c2suiapi.service.exception.ums;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class UmsClientInterfaceException extends RuntimeException {
    public UmsClientInterfaceException() {}

    public UmsClientInterfaceException(String message) {
        super(message);
    }
}
