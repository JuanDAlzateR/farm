package com.solvd.farm.animals;

//animals.Aquaculture → fish, shellfish
public class Aquaculture extends FarmAnimals {
    public Aquaculture() {
        super("New animal", 0, new AnimalFood(), new AnimalFeed());
    }

    public Aquaculture(String name, int quantity, AnimalFood animalFood, AnimalFeed animalFeed) {
        super(name, quantity, animalFood, animalFeed);
    }
}
