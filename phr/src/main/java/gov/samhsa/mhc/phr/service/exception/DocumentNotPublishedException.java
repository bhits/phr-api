package gov.samhsa.mhc.phr.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DocumentNotPublishedException extends RuntimeException {
    public DocumentNotPublishedException() {
    }

    public DocumentNotPublishedException(String message) {
        super(message);
    }

    public DocumentNotPublishedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DocumentNotPublishedException(Throwable cause) {
        super(cause);
    }

    public DocumentNotPublishedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
