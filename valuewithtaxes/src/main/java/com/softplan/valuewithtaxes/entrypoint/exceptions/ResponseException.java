package com.softplan.valuewithtaxes.entrypoint.exceptions;

public class ResponseException extends RuntimeException {

    public ResponseException(final String message) {
        super(message);
    }
}
