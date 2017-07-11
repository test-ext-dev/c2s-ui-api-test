package gov.samhsa.c2s.c2suiapi.service.exception.ums;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserAvatarNotFoundException extends RuntimeException {
    public UserAvatarNotFoundException() {}

    public UserAvatarNotFoundException(String message) {
        super(message);
    }
}
