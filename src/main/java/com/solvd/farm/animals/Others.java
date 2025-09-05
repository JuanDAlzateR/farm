package com.solvd.farm.animals;

import com.solvd.farm.animals.enums.OthersType;

//animals.Others → rabbits, bees, alpacas, others
public class Others extends FarmAnimals {
    OthersType type = OthersType.OTHERS;

    public Others(String name, int quantity, AnimalFood animalFood, AnimalFeed animalFeed) {
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
