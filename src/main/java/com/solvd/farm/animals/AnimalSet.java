package com.solvd.farm.animals;

import com.solvd.farm.crops.Grain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.logging.Logger;

public class AnimalSet {

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
        for (AnimalList animalList : animalTypes)
            animalList.display();
    }

    //    public void addAnimal(FarmAnimals animal) {
//        if (animal instanceof Livestock) {
//            livestockAnimalList.add((Livestock) animal);
//        }
//        if (animal instanceof Aquaculture) {
//            aquacultureAnimalList.add((Aquaculture) animal);
//        }
//        if (animal instanceof Equines) {
//            equinesAnimalList.add((Equines) animal);
//        }
//        if (animal instanceof Poultry) {
//            poultryAnimalList.add((Poultry) animal);
//        }
//        if (animal instanceof Others) {
//            othersAnimalList.add((Others) animal);
//        }
//    }
//
//    public int size() {
//        Map<AnimalList, Integer> sizes = new HashMap<>();
//        sizes.put(aquacultureAnimalList, aquacultureAnimalList.getList().size());
//        sizes.put(equinesAnimalList, equinesAnimalList.getList().size());
//        sizes.put(livestockAnimalList, livestockAnimalList.getList().size());
//        sizes.put(othersAnimalList, othersAnimalList.getList().size());
//        sizes.put(poultryAnimalList, poultryAnimalList.getList().size());
//        int totalSize = 0;
//        for (Integer i : sizes.values()) {
//            totalSize += i;
//        }
//        return totalSize;
//    }
//
//    public void display() {
//        aquacultureAnimalList.display();
//        equinesAnimalList.display();
//        livestockAnimalList.display();
//        poultryAnimalList.display();
//        othersAnimalList.display();
//    }
//
//    public void displayAllFeed() {
//        aquacultureAnimalList.displayAllFeed();
//        equinesAnimalList.displayAllFeed();
//        livestockAnimalList.displayAllFeed();
//        poultryAnimalList.displayAllFeed();
//        othersAnimalList.displayAllFeed();
//    }
//
//    public void passTime(int days) {
//        aquacultureAnimalList.passTime(days);
//        equinesAnimalList.passTime(days);
//        livestockAnimalList.passTime(days);
//        poultryAnimalList.passTime(days);
//        othersAnimalList.passTime(days);
//    }

}
