package com.solvd.farm.input;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class InputClass<T> implements IInputClass<T> {
    public static final Logger LOGGER = LogManager.getLogger(InputClass.class);
    private final Class<?> clazz; //the word class it's java reserved.
    private final InputHandler<T> inputHandler;
    private boolean isNumeric = false;
    private boolean needsValidation = false;

    public InputClass(Class<?> clazz, InputHandler<T> inputHandler) {
        this.clazz = clazz;
        this.inputHandler = inputHandler;

    }

    public InputClass(Class<?> clazz, Supplier<Exception> supplier) {
        this.clazz = clazz;

        IConstructor<T> iConstructor = createIConstructor(clazz);
        Constructor<T> constructor = new Constructor<>(clazz + "Constructor", iConstructor, supplier);
        InputHandler<T> inputHandler = new InputHandler<>(constructor);

        this.inputHandler = inputHandler;

    }

    public void setIsNumeric(boolean numeric) {
        this.isNumeric = numeric;
    }

    public void setNeedsValidation(boolean needsValidation) {
        this.needsValidation = needsValidation;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public boolean isNeedsValidation() {
        return needsValidation;
    }

    public boolean isNumeric() {
        return isNumeric;
    }

    @Override
    public T input(String message) {
        return inputHandler.input(message);
    }

    public void display() {
        LOGGER.info("Class: " + clazz);
        inputHandler.display();
    }

    public void throwException() throws Exception {
        throw inputHandler.getConstructor().getSupplier().get();
    }

    public Exception exception() {
        return inputHandler.getConstructor().getSupplier().get();
    }


    public IConstructor createIConstructor(Class<?> clazz) {
        if (clazz.equals(int.class)) {
            return (string) -> Integer.valueOf(string);
        } else if (clazz.equals(float.class)) {
            return (string) -> Float.valueOf(string);
        } else
            return (string) -> clazz.getDeclaredConstructor(String.class).newInstance(string);
    }

}
