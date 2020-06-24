package com.poc.blackfish.controller;

import com.poc.blackfish.exceptions.DuplicateResourceException;
import com.poc.blackfish.exceptions.ResourceNotFound;
import com.poc.blackfish.utils.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(DuplicateResourceException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ApiErrors handleDuplicateResourceException(DuplicateResourceException exception){
        String errorMessage = exception.getMessage();
        return new ApiErrors(errorMessage);
    }

    @ExceptionHandler(ResourceNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ApiErrors handleResourceNotFound(ResourceNotFound exception){
        String errorMessage = exception.getMessage();
        return new ApiErrors(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiErrors(errors);
    }
}
