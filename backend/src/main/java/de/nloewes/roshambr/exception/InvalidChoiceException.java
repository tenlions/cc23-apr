package de.nloewes.roshambr.exception;

import de.nloewes.roshambr.model.PlayerChoice;
import org.springframework.http.HttpStatus;

/**
 * Specific exception to be thrown in case an invalid {@link PlayerChoice} is provided via API.
 * When propagated, these exceptions shall be mapped to HTTP status 400.
 *
 * @author nloewes
 */
public class InvalidChoiceException extends RequestException {

    public InvalidChoiceException(String value) {
        super(HttpStatus.BAD_REQUEST, Errors.CHOICE_INVALID, value);
    }
}
