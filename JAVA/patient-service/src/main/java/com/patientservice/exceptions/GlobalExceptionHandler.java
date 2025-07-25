package com.patientservice.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static  final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handelValidationException(MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(),
                        error.getDefaultMessage())
                );

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExistException(EmailAlreadyExistException ex){

        log.warn("{}", ex.getMessage());
        Map<String, String > error = new HashMap<>();
        error.put("Message", "Email already exists");

        return ResponseEntity.badRequest().body(error);
     }

     @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePateintNotFoundException(PatientNotFoundException ex){

        Map<String, String> error = new HashMap<>();

        log.warn("{}",ex.getMessage());
        error.put("message", "Patient not found with id ");

        return ResponseEntity.badRequest().body(error);
     }
}
