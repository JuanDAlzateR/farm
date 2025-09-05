package com.solvd.farm.input;

import com.solvd.farm.exceptions.*;
import com.solvd.farm.menu.AllActions;
import com.solvd.farm.menu.AllMenus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.function.Supplier;

public class InputClass implements IInputClass{
    public static final Logger LOGGER = LogManager.getLogger(InputClass.class);
    private Class<?> clazz; //the word class it's java reserved.
    private Supplier<Exception> supplier;
    private boolean isNumeric=false;
    private boolean needsValidation=false;
    private IConstructor constructor;



    public InputClass(Class<?> clazz,Supplier<Exception> supplier){
        this.clazz=clazz;
        this.supplier=supplier;

        this.constructor=(string)->{
            try {
                return this.clazz.getDeclaredConstructor(String.class).newInstance(string);
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

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public void setSupplier(Supplier<Exception> supplier) {
        this.supplier = supplier;
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
    public Object input() {
        return null;
    }

    public boolean hasNextInput(){
        if(isNumeric){
            if(clazz.equals(int.class)){
                return AllMenus.scanner.hasNextInt();
            } else if (clazz.equals(float.class)) {
                return AllMenus.scanner.hasNextFloat();
            }
        }
        return true;
    }

    public static <T> T nextInput() {

        return null;
    }

    public <T> T construct(String string) {
        if(isNumeric){
            if(clazz.equals(int.class)){
                return (T) Integer.valueOf(string);
            } else if (clazz.equals(float.class)) {
                return (T) Float.valueOf(string);
            }
        }
        return (T) this.constructor.construct(string);
    }

    public void display(){
        LOGGER.info("Class: "+clazz);
        LOGGER.info("Supplier "+supplier);
        LOGGER.info("Constructor "+constructor);
    }

}
