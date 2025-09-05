package com.solvd.farm.animals;

import com.solvd.farm.animals.enums.EquinesType;

//animals.Equines → horses, donkeys, mules
public class Equines extends FarmAnimals {
    EquinesType type = EquinesType.UNDEFINED;

    public Equines(){super();}

    public Equines(String name, int quantity, AnimalFood animalFood, AnimalFeed animalFeed) {
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
