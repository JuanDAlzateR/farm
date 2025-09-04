package com.solvd.farm.animals.enums;

import java.util.HashMap;
import java.util.Map;

public enum OthersType implements IAnimalType<OthersType> {
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

    @Override
    public OthersType getDefault() {
        return OTHERS;
    }

    @Override
    public Map<String, OthersType> getLookup() {
        return lookup;
    }

}