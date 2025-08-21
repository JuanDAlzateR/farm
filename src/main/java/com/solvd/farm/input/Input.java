package com.solvd.farm.input;

import com.solvd.farm.Main;
import com.solvd.farm.exceptions.InvalidFloatException;
import com.solvd.farm.exceptions.InvalidIntException;
import com.solvd.farm.exceptions.InvalidMeasurementUnitException;
import com.solvd.farm.exceptions.InvalidNameException;
import com.solvd.farm.menu.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;

public class Input {
    public static final Logger LOGGER = LogManager.getLogger(Input.class);
    static List<Class<?>> classList = Arrays.asList(String.class, int.class, float.class, NameString.class, UnitMeasureString.class);
    static List<Class<?>> numberList = Arrays.asList(int.class, float.class);
    public static HashSet<Class<?>> classesSet = new HashSet<>(classList);
    public static HashMap<Class<?>, Supplier<Exception>> exceptions = new HashMap<>();

    static {
        exceptions.put(String.class, () -> new Exception());
        exceptions.put(int.class, () -> new InvalidIntException());
        exceptions.put(float.class, () -> new InvalidFloatException());
        exceptions.put(NameString.class, () -> new InvalidNameException());
        exceptions.put(UnitMeasureString.class, () -> new InvalidMeasurementUnitException());

    }
    //Create a NameClass and UnitMeasureClass, to handle their own exceptions.

    public static <T> T input(Class<T> inputClass, String message) {
        T input = null;
        boolean validateInput = false;
        while (!validateInput) {
            try {
                LOGGER.info(message);
                if (!hasNextInput(inputClass)) {
                    throw exceptions.get(inputClass).get();
                    //first get the supplier, then get the new exception provided by the supplier
                }
                input = nextInput(inputClass);
                validateInput = true;


            } catch (Exception e) {
                Main.LOGGER.warn("Invalid " + inputClass + " input...");
            } finally {
                if (numberList.contains(inputClass)) {
                    AllMenus.scanner.nextLine();
                }
            }

        }
        Main.LOGGER.debug(input + " input " + inputClass + " validated");
        return input;
    }

    public static boolean hasNextInput(Class<?> inputClass) {
        boolean out = false;
        if (classesSet.contains(inputClass)) {
            if (inputClass == int.class) {
                out = AllMenus.scanner.hasNextInt();

            } else if (inputClass == float.class) {
                out = AllMenus.scanner.hasNextFloat();

            } else {
                out = true;

            }
        } else {
            LOGGER.warn("unsupported class");
        }
        return out;
    }

    @SuppressWarnings("unchecked")
    public static <T> T nextInput(Class<T> inputClass) {

        if (classesSet.contains(inputClass)) {
            if (inputClass == int.class) {
                int input = AllMenus.scanner.nextInt();
                return (T) Integer.valueOf(input);

            } else if (inputClass == float.class) {
                float input = AllMenus.scanner.nextFloat();
                return (T) Float.valueOf(input);

            } else if (inputClass == String.class){
                String input = AllMenus.scanner.nextLine();
                return (T) input;

            }else if (inputClass == NameString.class){
                String input = AllMenus.scanner.nextLine();
                return (T) new NameString(input);

            }else if (inputClass == UnitMeasureString.class){
                String input = AllMenus.scanner.nextLine();
                return (T) new UnitMeasureString(input);

            }
        } else {
            LOGGER.warn("unsupported class");
        }
        return null;
    }

}