package com.solvd.farm.exceptions;

public class InvalidOptionException extends Exception {
    public InvalidOptionException(String message) {
        super(message);
    }

    public InvalidOptionException() {
        super("Invalid option input.");
    }
}