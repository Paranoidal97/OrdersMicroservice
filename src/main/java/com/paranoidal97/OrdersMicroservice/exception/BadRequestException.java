package com.paranoidal97.OrdersMicroservice.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends OrderException {

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
