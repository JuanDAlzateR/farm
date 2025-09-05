package com.solvd.farm.input;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class Constructor<T> implements IConstructor<T> {
    public static final Logger LOGGER = LogManager.getLogger(Constructor.class);
    private Predicate<String> validator;
    private final IConstructor<T> constructor;
    private final Supplier<Exception> supplier;
    private String constructorName;

    public Constructor(String name, IConstructor<T> constructor, Supplier<Exception> supplier) {
        this.constructorName = name;
        this.constructor = constructor;
        this.supplier = supplier;

        Predicate<String> validator = (string) -> {
            if (string == null || string.trim().isEmpty()) {
                return false;
            }
            try {
                T object = this.constructor.construct(string);
                return !object.toString().isEmpty(); //validate?
            } catch (Exception e) {
                return false;
            }
        };

        this.validator = validator;
    }

    public Constructor(Class<?>clazz, Supplier<Exception> supplier) {
        this(clazz+"Constructor",InputClass.createIConstructor(clazz),supplier);
    }

    public void setValidator(Predicate<String> validator) {
        this.validator = validator;
    }

    public void setConstructorName(String constructorName) {
        this.constructorName = constructorName;
    }

    public String getConstructorName() {
        return constructorName;
    }

    public Supplier<Exception> getSupplier() {
        return supplier;
    }

    @Override
    public T construct(String string) throws Exception {
        if (validator.test(string)) {
            return constructor.construct(string);
        } else {
            LOGGER.warn("Error-- constructor: " + constructorName + " | " + "string: " + string);
            throw supplier.get();
        }

    }

    @Override
    public String toString() {
        return constructorName;
    }

    public boolean validate(String string) {
        return validator.test(string);
    }

}
