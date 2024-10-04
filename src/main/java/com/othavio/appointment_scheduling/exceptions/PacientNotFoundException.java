package com.othavio.appointment_scheduling.exceptions;

public class PacientNotFoundException extends RuntimeException {

    public PacientNotFoundException(String message) {
        super(message);
    }

}
