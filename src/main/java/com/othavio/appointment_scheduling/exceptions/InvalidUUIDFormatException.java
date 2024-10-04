package com.othavio.appointment_scheduling.exceptions;

public class InvalidUUIDFormatException extends RuntimeException {
    public InvalidUUIDFormatException() {
        super("Invalid ID format.");
    }
}
