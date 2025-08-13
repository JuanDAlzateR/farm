package com.solvd.farm.animals;

import com.solvd.farm.abstracts.AbstractList;
import java.util.ArrayList;

public class AnimalList extends AbstractList {
    private ArrayList<FarmAnimals> animals = new ArrayList<>();

    /* Looks in the array for the index of item with that name
    If it doesn't find it, it returns -1  */
    @Override
    public int indexOfName(String name) {
        for (int i = 0; i< animals.size(); i++){
            if (animals.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public void add(FarmAnimals animal) {
        int index=indexOfName(animal.getName());
        if (index>-1){
            animals.get(index).addQuantity(animal.getQuantity());
        }else{
            animals.add(animal);
        }
    }

    public void display() {
        System.out.println();
        System.out.println("list of all animals in the farm");
        for (FarmAnimals animal : animals) {
            System.out.println(animal);
        }
    }

    public void displayAllFeed() {
        for (FarmAnimals animal : animals) {
            System.out.println(animal.getAnimalFeed());
        }
    }

    public ArrayList<FarmAnimals> getList() {
        return this.animals;
    }

}