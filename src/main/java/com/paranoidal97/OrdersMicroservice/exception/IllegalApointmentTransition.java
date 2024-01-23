package com.paranoidal97.OrdersMicroservice.exception;

import org.springframework.http.HttpStatus;

public class IllegalApointmentTransition extends OrderException {
    public IllegalApointmentTransition(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
