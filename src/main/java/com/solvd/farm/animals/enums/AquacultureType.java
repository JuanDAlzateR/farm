package com.solvd.farm.animals.enums;

import java.util.HashMap;
import java.util.Map;

public enum AquacultureType implements IAnimalType<AquacultureType> {
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

    @Override
    public AquacultureType getDefault() {
        return UNDEFINED;
    }

    @Override
    public Map<String, AquacultureType> getLookup() {
        return lookup;
    }

}