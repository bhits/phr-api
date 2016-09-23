package gov.samhsa.c2s.phr.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class PatientDataCannotBeRetrievedException extends RuntimeException {
    public PatientDataCannotBeRetrievedException() {
    }

    public PatientDataCannotBeRetrievedException(String message) {
        super(message);
    }

    public PatientDataCannotBeRetrievedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PatientDataCannotBeRetrievedException(Throwable cause) {
        super(cause);
    }

    public PatientDataCannotBeRetrievedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
