package com.decode.anpr.exception;

import lombok.Data;

@Data
public class DecodesError {
    private String code;
    private String message;
}
