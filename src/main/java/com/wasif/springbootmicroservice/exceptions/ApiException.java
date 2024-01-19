package com.wasif.springbootmicroservice.exceptions;

/*
* Copyright (c) 2024 Md Wasif Ali
*/

import org.springframework.http.HttpStatus;

/**
 * This is a custom exception class
 * It extends {@link RuntimeException}
 *
 * @author Wasif
 * @version 1.0
 * @since 18/01/24
 */
public class ApiException extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public ApiException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
