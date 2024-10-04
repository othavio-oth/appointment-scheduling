package com.othavio.appointment_scheduling.exceptions;

public class InvalidUUIDFormatException extends RuntimeException {
    public InvalidUUIDFormatException(String message) {
        super(message);
    }
}
