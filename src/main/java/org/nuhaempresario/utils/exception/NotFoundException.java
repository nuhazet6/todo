package org.nuhaempresario.utils.exception;

import java.io.Serializable;

public class NotFoundException extends RuntimeException implements Serializable {
    private final int statusCode;

    public NotFoundException() {
        statusCode = 404;
    }

    public NotFoundException(String message) {
        super(message);
        statusCode = 404;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
