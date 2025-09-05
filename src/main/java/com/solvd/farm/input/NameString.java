package com.solvd.farm.input;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NameString {
    public static final Logger LOGGER = LogManager.getLogger(NameString.class);
    public String name = "";

    public NameString(String name) {
        if (name.matches("[a-zA-Z ]+")) {
            this.name = name;
        }else{
            LOGGER.warn("construct of NameString("+name+") failed");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.matches("[a-zA-Z ]+")) {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
