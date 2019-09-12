package com.decode.anpr.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
@Slf4j
public class DecodeServiceFailureExceptionHandler {

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    @ResponseBody
    protected DecodesError handle(final DecodeServiceFailureException exception) {
        log.error("DecodeServiceFailureException: {}", exception.getMessage(), exception);
        DecodesError decodesError = new DecodesError();
        decodesError.setCode("D100");
        decodesError.setMessage(exception.getMessage());
        return decodesError;
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler
    @ResponseBody
    protected DecodesError handle(final NotFoundException exception) {
        log.error("NotFoundException: {}", exception.getMessage(), exception);
        DecodesError decodesError = new DecodesError();
        decodesError.setCode("D110");
        decodesError.setMessage(exception.getMessage());
        return decodesError;
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler
    @ResponseBody
    protected DecodesError handle(final BadRequestException exception) {
        log.error("BadRequestException: {}", exception.getMessage(), exception);
        DecodesError decodesError = new DecodesError();
        decodesError.setCode("D120");
        decodesError.setMessage(exception.getMessage());
        return decodesError;
    }

    @ResponseStatus(UNAUTHORIZED)
    @ExceptionHandler
    @ResponseBody
    protected DecodesError handle(final DecodeUnauthorizedException exception) {
        log.error("DecodeUnauthorizedException: {}", exception.getMessage(), exception);
        DecodesError decodesError = new DecodesError();
        decodesError.setCode("D120");
        decodesError.setMessage(exception.getMessage());
        return decodesError;
    }
}
