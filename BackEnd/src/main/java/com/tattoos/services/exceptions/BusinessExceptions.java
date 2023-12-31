package com.tattoos.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessExceptions extends RuntimeException{

    private static final long serivalVersionUID = 1L;

    public BusinessExceptions(String msg) {
        super(msg);
    }
}
