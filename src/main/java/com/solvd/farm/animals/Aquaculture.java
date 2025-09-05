package com.solvd.farm.animals;

import com.solvd.farm.animals.enums.AquacultureType;

//animals.Aquaculture → fish, shellfish
public class Aquaculture extends FarmAnimals {
    AquacultureType type = AquacultureType.UNDEFINED;

    //in spite of warning of no usages, this constructor it's used in AllActions.createAnimal
    @SuppressWarnings("unused")
    public Aquaculture() {
        super();
    }

    @SuppressWarnings("unused")
    public Aquaculture(String name, int quantity, AnimalFood animalFood, AnimalFeed animalFeed) {
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
