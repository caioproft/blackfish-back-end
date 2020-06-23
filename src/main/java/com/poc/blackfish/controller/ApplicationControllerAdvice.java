package com.poc.blackfish.controller;

import com.poc.blackfish.exceptions.DuplicateResourceException;
import com.poc.blackfish.utils.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(DuplicateResourceException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ApiErrors handleDuplicateResourceException(DuplicateResourceException exception){
        String errorMessage = exception.getMessage();
        return new ApiErrors(errorMessage);
    }
}
