package com.decode.anpr.client;

import com.decode.anpr.exception.BadRequestException;
import com.decode.anpr.exception.DecodeServiceFailureException;
import com.decode.anpr.exception.DecodeUnauthorizedException;
import com.decode.anpr.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        log.error("Unsuccessful request to motor policy API. Response code: [{}], Response [{}]",
                response.status(), response);

        final Exception exception;
        switch (HttpStatus.valueOf(response.status())) {
            case NOT_FOUND:
                exception = new NotFoundException("Decode not found.");
                break;
            case UNAUTHORIZED:
            case FORBIDDEN:
                exception = new DecodeUnauthorizedException("Not Unauthorized.");
                break;
            case BAD_REQUEST:
                exception = new BadRequestException("Bad request.");
                break;
            default:
                exception = new DecodeServiceFailureException("Server failure.");
                break;
        }

        return exception;
    }
}
