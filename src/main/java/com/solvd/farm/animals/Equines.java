package com.solvd.farm.animals;

//animals.Equines → horses, donkeys
public class Equines extends FarmAnimals {
    public Equines() {
        super("New animal", 0, new AnimalFood(), new AnimalFeed());
    }

    public Equines(String name, int quantity, AnimalFood animalFood, AnimalFeed animalFeed) {
        super(name, quantity, animalFood, animalFeed);
    }
}
