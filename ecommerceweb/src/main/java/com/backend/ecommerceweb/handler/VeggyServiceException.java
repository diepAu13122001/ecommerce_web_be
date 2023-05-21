package com.backend.ecommerceweb.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class VeggyServiceException extends ResponseStatusException {

    @Getter
    private Object data;

    public VeggyServiceException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

    public VeggyServiceException(String message, Object data) {
        super(HttpStatus.NOT_FOUND, message);
        this.data = data;
    }
}
