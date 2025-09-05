package com.solvd.farm.animals;

import com.solvd.farm.animals.enums.LivestockType;

//animals.Livestock -> Cattle, pigs, sheep, goats
public class Livestock extends FarmAnimals {
    LivestockType type = LivestockType.UNDEFINED;

    @SuppressWarnings("unused")
    public Livestock(){super();}

    public Livestock(String name, int quantity, AnimalFood animalFood, AnimalFeed animalFeed) {
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
