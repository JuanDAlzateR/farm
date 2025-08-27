package com.solvd.farm.animals.enums;

import java.util.HashMap;
import java.util.Map;

public enum OthersType {
    OTHERS, RABBITS, BEES, ALPACAS;

    //synonym dictionary
    private static final Map<String, OthersType> lookup = new HashMap<>();

    static {
        // CHICKENS
        lookup.put("rabbit", RABBITS);
        lookup.put("rabbits", RABBITS);

        // TURKEYS
        lookup.put("bee", BEES);
        lookup.put("bees", BEES);

        // DUCKS
        lookup.put("alpaca", ALPACAS);
        lookup.put("alpacas", ALPACAS);

    }

    public static OthersType fromString(String input) {
        if (input == null) {
            return OTHERS;
        }
        return lookup.getOrDefault(input.trim().toLowerCase(), OTHERS);
    }

}