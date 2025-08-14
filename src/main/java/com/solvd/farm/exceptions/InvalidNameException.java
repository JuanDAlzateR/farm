package com.solvd.farm.exceptions;

public class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }

    public InvalidNameException() {
        super("Invalid input name.");
    }
}