package com.solvd.farm.input;

public class NameString {
    public String name = "";

    public NameString(String name) {
        if (name.matches("[a-zA-Z ]+")) {
            this.name = name;
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
