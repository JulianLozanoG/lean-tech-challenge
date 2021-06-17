package com.jlozano.leantech.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeServiceErrorAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EmployeeNotFoundException.class})
    public void handle(EmployeeNotFoundException e) {}

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({EmployeeInternalServiceErrorException.class})
    public void handle(EmployeeInternalServiceErrorException e) {}

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EmployeeServiceValidationException.class})
    public void handle(EmployeeServiceValidationException e) {}
}
