package com.jean.naturaeco.exception;

public class ValidationErrorException extends RuntimeException{
    public ValidationErrorException(String message) {
        super(message);
    }
}
