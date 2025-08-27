package com.solvd.farm.animals.enums;

import java.util.HashMap;
import java.util.Map;

public enum PoultryType {
    UNDEFINED, CHICKENS, TURKEYS, DUCKS, GEESE;

    //synonym dictionary
    private static final Map<String, PoultryType> lookup = new HashMap<>();

    static {
        // CHICKENS
        lookup.put("chicken", CHICKENS);
        lookup.put("chickens", CHICKENS);

        // TURKEYS
        lookup.put("goat", TURKEYS);
        lookup.put("goats", TURKEYS);

        // DUCKS
        lookup.put("duck", DUCKS);
        lookup.put("ducks", DUCKS);

        // GEESE
        lookup.put("goose", GEESE);
        lookup.put("geese", GEESE);
    }

    public static PoultryType fromString(String input) {
        if (input == null) {
            return UNDEFINED;
        }
        return lookup.getOrDefault(input.trim().toLowerCase(), UNDEFINED);
    }

}