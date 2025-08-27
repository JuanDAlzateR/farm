package com.solvd.farm.animals.enums;

import java.util.HashMap;
import java.util.Map;

public enum AquacultureType {
    UNDEFINED, FISH, SHELLFISH;

    //synonym dictionary
    private static final Map<String, AquacultureType> lookup = new HashMap<>();

    static {
        // FISH
        lookup.put("fish", FISH);
        lookup.put("fishes", FISH);

        // SHELLFISH
        lookup.put("shellfish", SHELLFISH);
        lookup.put("shellfishes", SHELLFISH);

    }

    public static AquacultureType fromString(String input) {
        if (input == null) {
            return UNDEFINED;
        }
        return lookup.getOrDefault(input.trim().toLowerCase(), UNDEFINED);
    }

}