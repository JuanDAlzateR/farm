package com.solvd.farm.exceptions;

public class InvalidMeasurementUnitException extends Exception {
    public InvalidMeasurementUnitException(String message) {
        super(message);
    }

    public InvalidMeasurementUnitException() {
        super("Invalid measurement unit input.");
    }
}