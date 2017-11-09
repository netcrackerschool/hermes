package com.hermes.application.states;

/**
 *  01.10.15.
 */
public class NoSuchLoginException extends Exception {
    public NoSuchLoginException() {
    }

    public NoSuchLoginException(String message) {
        super(message);
    }

    public NoSuchLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchLoginException(Throwable cause) {
        super(cause);
    }

    public NoSuchLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
