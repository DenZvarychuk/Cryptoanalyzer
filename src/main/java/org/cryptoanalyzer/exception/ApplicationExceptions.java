package org.cryptoanalyzer.exception;

public class ApplicationExceptions extends RuntimeException {
    public ApplicationExceptions(String message) {
        super(message);
    }

    public ApplicationExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationExceptions(Throwable cause) {
        super(cause);
    }

    public ApplicationExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ApplicationExceptions() {
    }
}
