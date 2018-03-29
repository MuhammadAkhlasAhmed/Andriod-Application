package com.app.exception;

/**
 * This is the CustomException class
 *
 * @author ahayat
 */
public class CustomException extends RuntimeException {

    public CustomException () {

    }

    public CustomException (String message) {
        super(message);
    }
}
