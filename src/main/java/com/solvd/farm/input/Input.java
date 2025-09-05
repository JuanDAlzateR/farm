package com.solvd.farm.input;

import com.solvd.farm.exceptions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;

public class Input {
    public static final Logger LOGGER = LogManager.getLogger(Input.class);
    public static HashSet<InputClass<?>> classesSet = new HashSet<>();

    static {
        InputClass<String> stringInputClass = new InputClass<>(String.class, Exception::new);
        InputClass<Integer> integerInputClass = new InputClass<>(int.class, InvalidIntException::new);
        InputClass<Float> floatInputClass = new InputClass<>(float.class, InvalidFloatException::new);
        InputClass<NameString> nameStringInputClass = new InputClass<>(NameString.class, InvalidNameException::new);
        InputClass<UnitMeasureString> unitMeasureInputClass = new InputClass<>(UnitMeasureString.class, InvalidMeasurementUnitException::new);

        integerInputClass.setIsNumeric(true);
        floatInputClass.setIsNumeric(true);
        nameStringInputClass.setNeedsValidation(true);
        unitMeasureInputClass.setNeedsValidation(true);

        classesSet.add(stringInputClass);
        classesSet.add(integerInputClass);
        classesSet.add(floatInputClass);
        classesSet.add(nameStringInputClass);
        classesSet.add(unitMeasureInputClass);

    }

    public static <T> T input(Class<T> tClass, String message) throws Exception {
        InputClass<T> inputClass = contains(tClass);
        if (!inputClass.equals(null)) {
            return inputClass.input(message);
        } else {
            LOGGER.warn("class " + tClass + " not admited");
            throw inputClass.exception();
        }
    }

    public static <T> InputClass contains(Class<T> tClass) {
        for (InputClass inputClass : classesSet) {
            if (inputClass.getClazz().equals(tClass)) {
                return inputClass;
            }
        }
        return null;
    }

}