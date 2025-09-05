package com.solvd.farm.input;

import com.solvd.farm.menu.AllMenus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputHandler<T> implements IInputClass<T> {
    public static final Logger LOGGER = LogManager.getLogger(InputHandler.class);
    private IInputString inputString;
    private Constructor<T> constructor;

    public InputHandler(IInputString inputString, Constructor<T> constructor) {
        this.inputString = inputString;
        this.constructor = constructor;

    }

    public InputHandler(Constructor<T> constructor) {
        this.constructor = constructor;
        this.inputString = () -> AllMenus.scanner.nextLine();

    }

    public void setInputString(IInputString inputString) {
        this.inputString = inputString;
    }

    public void setConstructor(Constructor<T> constructor) {
        this.constructor = constructor;
    }

    public Constructor<T> getConstructor() {
        return constructor;
    }

    @Override
    public T input(String message) {
        T input = null;
        boolean validateInput = false;

        while (!validateInput) {
            try {
                LOGGER.info(message);
                String string = inputString.input();
                validateInput = constructor.validate(string);
                input = constructor.construct(string);
            } catch (Exception e) {
                //LOGGER.warn("input error");
            }
        }
        return input;
    }

    public void display() {
        LOGGER.info("Constructor: " + constructor);
    }

}
