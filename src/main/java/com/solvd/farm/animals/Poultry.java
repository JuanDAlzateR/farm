package com.solvd.farm.animals;

//animals.Poultry → chickens, turkeys, ducks, geese
public class Poultry extends FarmAnimals {
    public Poultry() {
        super("New animal", 0, new AnimalFood(), new AnimalFeed());
    }

    public Poultry(String name, int quantity, AnimalFood animalFood, AnimalFeed animalFeed) {
        super(name, quantity, animalFood, animalFeed);
    }
}
