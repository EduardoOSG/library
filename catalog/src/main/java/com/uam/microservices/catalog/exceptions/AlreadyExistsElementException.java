package com.uam.microservices.catalog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class AlreadyExistsElementException extends RuntimeException {

    public AlreadyExistsElementException(String msg) {
        super(msg);
    }
}
