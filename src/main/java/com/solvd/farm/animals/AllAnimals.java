package com.solvd.farm.animals;

import java.util.HashMap;
import java.util.Map;

public class AllAnimals {
    private AnimalList<Aquaculture> aquacultureAnimalList;
    private AnimalList<Equines> equinesAnimalList;
    private AnimalList<Livestock> livestockAnimalList;
    private AnimalList<Others> othersAnimalList;
    private AnimalList<Poultry> poultryAnimalList;


    public AllAnimals(){
        this.aquacultureAnimalList=new AnimalList<>();
        this.equinesAnimalList=new AnimalList<>();
        this.livestockAnimalList=new AnimalList<>();
        this.othersAnimalList=new AnimalList<>();
        this.poultryAnimalList=new AnimalList<>();

    }

    public AnimalList<Aquaculture> getAquacultureAnimalList2() {
        return aquacultureAnimalList;
    }
    public AnimalList<Equines> getEquinesAnimalList2() {
        return equinesAnimalList;
    }
    public AnimalList<Livestock> getLivestockAnimalList2() {
        return livestockAnimalList;
    }
    public AnimalList<Others> getOthersAnimalList2() {
        return othersAnimalList;
    }
    public AnimalList<Poultry> getPoultryAnimalList2() {
        return poultryAnimalList;
    }

    public void addAnimal(FarmAnimals animal){
        if (animal instanceof Livestock){
            livestockAnimalList.add((Livestock) animal);
        }
        if (animal instanceof Aquaculture){
            aquacultureAnimalList.add((Aquaculture) animal);
        }
        if (animal instanceof Equines){
            equinesAnimalList.add((Equines) animal);
        }
        if (animal instanceof Poultry){
            poultryAnimalList.add((Poultry) animal);
        }
        if (animal instanceof Others){
            othersAnimalList.add((Others) animal);
        }
    }

    public int size(){
        Map<AnimalList, Integer> sizes = new HashMap<>();
        sizes.put(aquacultureAnimalList, aquacultureAnimalList.getList().size());
        sizes.put(equinesAnimalList, equinesAnimalList.getList().size());
        sizes.put(livestockAnimalList, livestockAnimalList.getList().size());
        sizes.put(othersAnimalList, othersAnimalList.getList().size());
        sizes.put(poultryAnimalList, poultryAnimalList.getList().size());
        int totalSize=0;
        for (Integer i:sizes.values()){
            totalSize+=i;
        }
       return totalSize;
    }

    public void display(){
        aquacultureAnimalList.display();
        equinesAnimalList.display();
        livestockAnimalList.display();
        poultryAnimalList.display();
        othersAnimalList.display();
    }

    public void displayAllFeed(){
        aquacultureAnimalList.displayAllFeed();
        equinesAnimalList.displayAllFeed();
        livestockAnimalList.displayAllFeed();
        poultryAnimalList.displayAllFeed();
        othersAnimalList.displayAllFeed();
    }

    public void passTime(int days){
        aquacultureAnimalList.passTime(days);
        equinesAnimalList.passTime(days);
        livestockAnimalList.passTime(days);
        poultryAnimalList.passTime(days);
        othersAnimalList.passTime(days);
    }

}
