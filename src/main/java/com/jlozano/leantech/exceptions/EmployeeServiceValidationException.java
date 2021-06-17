package com.jlozano.leantech.exceptions;

public class EmployeeServiceValidationException extends RuntimeException{
    public EmployeeServiceValidationException(String message) {
        super(message);
    }
}
