package com.dk.library.exception;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode (callSuper = false)
public class ErrorCodeException extends RuntimeException {

    private final int httpStatus;
    private final String code;
    private final String message;
}

