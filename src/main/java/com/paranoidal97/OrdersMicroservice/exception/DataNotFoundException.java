package com.paranoidal97.OrdersMicroservice.exception;

import org.springframework.http.HttpStatus;

public class DataNotFoundException extends OrderException {
    public DataNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
