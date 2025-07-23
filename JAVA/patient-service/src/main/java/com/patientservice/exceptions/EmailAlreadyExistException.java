package com.patientservice.exceptions;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class EmailAlreadyExistException extends RuntimeException {

    public EmailAlreadyExistException(String message) {

        super(message);

    }
}
