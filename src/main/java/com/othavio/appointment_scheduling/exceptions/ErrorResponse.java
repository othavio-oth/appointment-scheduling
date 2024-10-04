package com.othavio.appointment_scheduling.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {

    private int status;
    private String message;

}
