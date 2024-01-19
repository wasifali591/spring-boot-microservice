package com.wasif.springbootmicroservice.exceptions;
/*
 * Copyright (c) 2024 Md Wasif Ali
 */

import org.springframework.http.HttpStatus;

/**
 * This is a custom exception class for resource not found
 * It extends {@link ApiException}
 *
 * @author Wasif
 * @version 1.0
 * @since 18/01/24
 */
public class ValidationException extends ApiException{
    public ValidationException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
