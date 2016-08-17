package gov.samhsa.c2s.phr.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PatientNotSavedException extends RuntimeException {
    public PatientNotSavedException() {
    }

    public PatientNotSavedException(String message) {
        super(message);
    }

    public PatientNotSavedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PatientNotSavedException(Throwable cause) {
        super(cause);
    }

    public PatientNotSavedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
