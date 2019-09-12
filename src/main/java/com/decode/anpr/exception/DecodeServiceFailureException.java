package com.decode.anpr.exception;


public class DecodeServiceFailureException extends RuntimeException {

    public DecodeServiceFailureException(final String message) {
        super(message);
    }

    public DecodeServiceFailureException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
