package com.solvd.farm.animals;

import com.solvd.farm.animals.enums.PoultryType;

//animals.Poultry → chickens, turkeys, ducks, geese
public class Poultry extends FarmAnimals {
    PoultryType type;
    public Poultry() {
        super("New animal", 0, new AnimalFood(), new AnimalFeed());
    }

    public Poultry(String name, int quantity, AnimalFood animalFood, AnimalFeed animalFeed) {
        super(name, quantity, animalFood, animalFeed);
        type= PoultryType.fromString(name);
    }

    @Override
    public String toString() {
        return super.toString()+" | "+type;
    }

    @Override
    public void setAnimal(String name, int quantity, AnimalFood animalFood, AnimalFeed animalFeed) {
        super.setAnimal(name,quantity,animalFood,animalFeed);
        type= PoultryType.fromString(name);
    }
}
