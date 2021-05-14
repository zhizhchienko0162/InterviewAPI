package com.gleb.interview.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String source) {
        super("Could not find " + source);
    }
}