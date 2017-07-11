package gov.samhsa.c2s.c2suiapi.service.exception.ums;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidAvatarInputException extends RuntimeException {
    public InvalidAvatarInputException() {}

    public InvalidAvatarInputException(String message) {
        super(message);
    }
}
