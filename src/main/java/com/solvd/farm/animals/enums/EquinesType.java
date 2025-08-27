package com.solvd.farm.animals.enums;

import java.util.HashMap;
import java.util.Map;

public enum EquinesType {
    UNDEFINED, HORSES, DONKEYS, MULES;

    //synonym dictionary
    private static final Map<String, EquinesType> lookup = new HashMap<>();

    static {
        // HORSES
        lookup.put("horse", HORSES);
        lookup.put("horses", HORSES);

        // DONKEYS
        lookup.put("donkey", DONKEYS);
        lookup.put("donkeys", DONKEYS);

        // MULES
        lookup.put("mule", MULES);
        lookup.put("mules", MULES);

    }

    public static EquinesType fromString(String input) {
        if (input == null) {
            return UNDEFINED;
        }
        return lookup.getOrDefault(input.trim().toLowerCase(), UNDEFINED);
    }

}