package com.solvd.farm.animals.enums;

import java.util.HashMap;
import java.util.Map;

public enum LivestockType {
    UNDEFINED, CATTLE, PIGS, SHEEP, GOATS;

    //synonym dictionary
    private static final Map<String, LivestockType> lookup = new HashMap<>();

    static {
        // CATTLE
        lookup.put("cow", CATTLE);
        lookup.put("cows", CATTLE);
        lookup.put("bull", CATTLE);
        lookup.put("bulls", CATTLE);

        // GOATS
        lookup.put("goat", GOATS);
        lookup.put("goats", GOATS);

        // PIGS
        lookup.put("pig", PIGS);
        lookup.put("pigs", PIGS);

        // SHEEP
        lookup.put("sheep", SHEEP);
    }

    public static LivestockType fromString(String input) {
        if (input == null) {
            return UNDEFINED;
        }
        return lookup.getOrDefault(input.trim().toLowerCase(), UNDEFINED);
    }

}