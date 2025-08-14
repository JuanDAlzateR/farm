package com.solvd.farm.exceptions;

public class InvalidFloatException extends Exception {
    public InvalidFloatException(String message) {
        super(message);
    }

    public InvalidFloatException() {
        super("Invalid float input.");
    }
}