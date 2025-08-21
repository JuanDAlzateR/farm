package com.solvd.farm.input;

public class UnitMeasureString {
    public String unitMeasure="";

    public UnitMeasureString(String unitMeasure){
        if(validateMeasurementUnit(unitMeasure)){
            this.unitMeasure=unitMeasure;
        }
    }

    public void setUnitMeasure(String unitMeasure) {
        if(validateMeasurementUnit(unitMeasure)){
            this.unitMeasure=unitMeasure;
        }
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public static boolean validateMeasurementUnit(String input) {
        String[][] units = {
                {"kilogram", "kg"},
                {"gram", "g"},
                {"milligram", "mg"},
                {"ton", "t"},
                {"pound", "lb"},
                {"ounce", "oz"},
                {"liter", "L"},
                {"milliliter", "mL"},
                {"gallon", "gal"},
                {"pint", "pt"},
                {"quart", "qt"},
        };

        boolean validateInput = false;

        for (String[] unit : units) {
            if (unit[0].equalsIgnoreCase(input) || unit[1].equalsIgnoreCase(input)) {
                validateInput = true;
                break;
            }
        }
        return validateInput;
    }

}
