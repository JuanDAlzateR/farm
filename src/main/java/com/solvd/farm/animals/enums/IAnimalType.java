package com.solvd.farm.animals.enums;

import java.util.Map;

public interface IAnimalType<E extends Enum<E>> {
    E getDefault();
    Map<String, E> getLookup();

    default E enumFromString(String input) {
        if (input == null) {
            return getDefault();
        }
        return getLookup().getOrDefault(input.trim().toLowerCase(), getDefault());
    }
}

