package com.solvd.farm.animals;

import com.solvd.farm.crops.Grain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.logging.Logger;

public class AnimalSet <T extends FarmAnimals> {

    private LinkedHashSet<AnimalList> animalTypes= new LinkedHashSet<>();

    public AnimalSet() {
        AnimalList<Aquaculture> aquacultureAnimalList=new AnimalList<>(Aquaculture.class);
        AnimalList<Equines> equinesAnimalList=new AnimalList<>(Equines.class);
        AnimalList<Livestock> livestockAnimalList=new AnimalList<>(Livestock.class);
        AnimalList<Others> othersAnimalList=new AnimalList<>(Others.class);
        AnimalList<Poultry> poultryAnimalList=new AnimalList<>(Poultry.class);

        animalTypes.add(aquacultureAnimalList);
        animalTypes.add(equinesAnimalList);
        animalTypes.add(livestockAnimalList);
        animalTypes.add(poultryAnimalList);
        animalTypes.add(othersAnimalList);

    }

    public LinkedHashSet<AnimalList> getAnimalTypes() {
        return animalTypes;
    }

    public void display(){
        for (AnimalList animalList : animalTypes) {
            animalList.display();
        }
    }

        public void addAnimal(FarmAnimals animal) {
        Class<T> animalClass= (Class<T>) animal.getClass();

        for (AnimalList animalList:animalTypes){
            if (animalList.getFarmAnimalClass().equals(animalClass)){
                animalList.add(animal);
            }
        }

    }

    public int size() {
        int totalSize = 0;
        for (AnimalList animalList : animalTypes){
            totalSize+=animalList.getList().size();
            }
        return totalSize;
    }

    public void displayAllFeed() {
        for (AnimalList animalList : animalTypes) {
            animalList.displayAllFeed();
        }
    }

    public void passTime(int days) {
        for (AnimalList animalList : animalTypes) {
            animalList.passTime(days);
        }
    }

}
