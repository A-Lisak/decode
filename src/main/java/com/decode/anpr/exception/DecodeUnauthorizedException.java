package com.decode.anpr.exception;

import lombok.Getter;

@Getter
public class DecodeUnauthorizedException extends RuntimeException {

    public DecodeUnauthorizedException(final String message) {
        super(message);
    }
}
