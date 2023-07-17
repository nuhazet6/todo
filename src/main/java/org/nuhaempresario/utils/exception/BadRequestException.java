package org.nuhaempresario.utils.exception;

import java.io.Serializable;

public class BadRequestException extends RuntimeException implements Serializable {
    private final int statusCode;
    public BadRequestException() {
        super();
        statusCode = 400;
    }

    public BadRequestException(String message) {
        super(message);
        statusCode = 400;
    }
}
