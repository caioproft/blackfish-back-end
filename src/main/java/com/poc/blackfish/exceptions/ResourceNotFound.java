package com.poc.blackfish.exceptions;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String msg) {
        super(msg);
    }
}
