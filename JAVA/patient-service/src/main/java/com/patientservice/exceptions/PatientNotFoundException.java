package com.patientservice.exceptions;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(String message) {

        super(message);
    }
}
