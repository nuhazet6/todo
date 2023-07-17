package org.nuhaempresario.utils.exception;

import java.io.Serializable;

public class ServerErrorException extends RuntimeException implements Serializable {
    private final int statusCode;

    public ServerErrorException() {
        this.statusCode = 500;
    }

    public ServerErrorException(String message) {
        super(message);
        this.statusCode = 500;
    }
}
