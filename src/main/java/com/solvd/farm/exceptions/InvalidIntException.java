package com.solvd.farm.exceptions;

public class InvalidIntException extends Exception {
    public InvalidIntException(String message) {
        super(message);
    }

    public InvalidIntException() {
        super("Invalid int input.");
    }
}