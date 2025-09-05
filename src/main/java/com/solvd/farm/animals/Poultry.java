package com.solvd.farm.animals;

import com.solvd.farm.animals.enums.PoultryType;

//animals.Poultry → chickens, turkeys, ducks, geese
public class Poultry extends FarmAnimals {
    PoultryType type = PoultryType.UNDEFINED;

    public Poultry(String name, int quantity, AnimalFood animalFood, AnimalFeed animalFeed) {
        super(name, quantity, animalFood, animalFeed);
        type = type.enumFromString(name);
    }

    @Override
    public String toString() {
        return super.toString() + " | " + type;
    }

    @Override
    public void setAnimal(String name, int quantity, AnimalFood animalFood, AnimalFeed animalFeed) {
        super.setAnimal(name, quantity, animalFood, animalFeed);
        type = type.enumFromString(name);
    }
}
