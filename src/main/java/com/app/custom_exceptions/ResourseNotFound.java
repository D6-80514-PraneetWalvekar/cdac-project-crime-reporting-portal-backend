package com.app.custom_exceptions;

public class ResourseNotFound extends RuntimeException{
    public ResourseNotFound(String message) {
        super(message);
    }
}
