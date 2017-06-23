package gov.samhsa.c2s.c2suiapi.service.exception.checkedexceptions;

/* Do NOT annotate this exception with @ResponseStatus.
*
*  This is a checked exception which must be caught and
*  handled inside of c2s-ui-api.
* */
public class UserAuthIdNotFoundException extends AbstractUserAuthIdException {
    public UserAuthIdNotFoundException() {}

    public UserAuthIdNotFoundException(String message) {
        super(message);
    }
}
