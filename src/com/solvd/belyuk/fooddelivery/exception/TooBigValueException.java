package com.solvd.belyuk.fooddelivery.exception;

public class TooBigValueException extends Exception {
    public TooBigValueException() {
        super();
    }

    public TooBigValueException(String message) {
        super(message);
    }

    public TooBigValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooBigValueException(Throwable cause) {
        super(cause);
    }
}
