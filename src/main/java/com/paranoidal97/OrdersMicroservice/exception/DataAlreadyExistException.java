package com.paranoidal97.OrdersMicroservice.exception;

import org.springframework.http.HttpStatus;

public class DataAlreadyExistException extends OrderException {
    public DataAlreadyExistException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
