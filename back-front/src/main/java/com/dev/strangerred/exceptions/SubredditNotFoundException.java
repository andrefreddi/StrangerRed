package com.dev.strangerred.exceptions;

public class SubredditNotFoundException extends RuntimeException {

    public SubredditNotFoundException(String message) {
        super(message);
    }
}