package com.jlozano.leantech.exceptions;

public class EmployeeInternalServiceErrorException extends RuntimeException{
    public EmployeeInternalServiceErrorException(String message) {
        super(message);
    }
}
