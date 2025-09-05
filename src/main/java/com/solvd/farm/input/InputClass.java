package com.solvd.farm.input;

import com.solvd.farm.Main;
import com.solvd.farm.menu.AllMenus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.function.Supplier;

public class InputClass<T> implements IInputClass<T> {
    public static final Logger LOGGER = LogManager.getLogger(InputClass.class);
    private final Class<?> clazz; //the word class it's java reserved.
    private final Supplier<Exception> supplier;
    private boolean isNumeric = false;
    private boolean needsValidation = false;
    private final IConstructor<T> constructor;


    public InputClass(Class<?> clazz, Supplier<Exception> supplier) {
        this.clazz = clazz;
        this.supplier = supplier;

        this.constructor = (string) -> {
            try {
                return (T) this.clazz.getDeclaredConstructor(String.class).newInstance(string);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
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
        T input = null;
        boolean validateInput = false;
        while (!validateInput) {
            try {
                LOGGER.info(message);
                if (!hasNextInput()) {
                    throw supplier.get();
                    //first get the supplier, then get the new exception provided by the supplier
                }
                input = nextInput();

                //validate the String inputs for the constructor of the class.
                if (needsValidation) {
                    if (input.toString().isEmpty()) {
                        throw supplier.get();
                    }
                }
                validateInput = true;

            } catch (Exception e) {
                Main.LOGGER.warn("Invalid " + clazz + " input...");
            } finally {
                if (isNumeric) {
                    AllMenus.scanner.nextLine();
                }
            }

        }
        Main.LOGGER.debug(input + " input " + clazz + " validated");
        return input;
    }

    public boolean hasNextInput() {
        if (isNumeric) {
            if (clazz.equals(int.class)) {
                return AllMenus.scanner.hasNextInt();
            } else if (clazz.equals(float.class)) {
                return AllMenus.scanner.hasNextFloat();
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public T nextInput() {
        if (isNumeric) {
            if (clazz.equals(int.class)) {
                int input = AllMenus.scanner.nextInt();
                return (T) Integer.valueOf(input);
            } else if (clazz.equals(float.class)) {
                float input = AllMenus.scanner.nextFloat();
                return (T) Float.valueOf(input);
            }
        }
        String input = AllMenus.scanner.nextLine();
        return this.constructor.construct(input);

    }

    @SuppressWarnings("unchecked")
    public T construct(String string) {
        if (isNumeric) {
            if (clazz.equals(int.class)) {
                return (T) Integer.valueOf(string);
            } else if (clazz.equals(float.class)) {
                return (T) Float.valueOf(string);
            }
        }
        return this.constructor.construct(string);
    }

    public void display() {
        LOGGER.info("Class: " + clazz);
        LOGGER.info("Supplier " + supplier);
        LOGGER.info("Constructor " + constructor);
    }

}
