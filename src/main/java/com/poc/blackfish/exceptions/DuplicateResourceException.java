package com.poc.blackfish.exceptions;

public class DuplicateResourceException extends RuntimeException {

    public DuplicateResourceException(String msg) {
        super(msg);
    }
}
