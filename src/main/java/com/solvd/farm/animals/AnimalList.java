package com.solvd.farm.animals;

import com.solvd.farm.abstracts.AbstractList;
import com.solvd.farm.crops.Grain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class AnimalList<T extends FarmAnimals> extends AbstractList {
    public static final Logger LOGGER = LogManager.getLogger(AnimalList.class);
    private ArrayList<T> animals = new ArrayList<>();
    private Class<T> farmAnimalClass;

    public AnimalList(Class<T> farmAnimalClass){
        this.farmAnimalClass=farmAnimalClass;
    }

    public Class<T> getFarmAnimalClass() {
        return farmAnimalClass;
    }

    /* Looks in the array for the index of item with that name
        If it doesn't find it, it returns -1  */
    @Override
    public int indexOfName(String name) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void add(T animal) {
        int index = indexOfName(animal.getName());
        if (index > -1) {
            animals.get(index).addQuantity(animal.getQuantity());
        } else {
            animals.add(animal);
        }
    }

    public void display() {
        LOGGER.info("");
        LOGGER.info("list of " + getNameOfClass() + " animals in the farm");

        for (T animal : animals) {
            LOGGER.info(animal);
        }
    }

    public void displayAllFeed() {
        for (T animal : animals) {
            LOGGER.info(animal.getAnimalFeed());
        }
    }

    public ArrayList<T> getList() {
        return this.animals;
    }

    public String getNameOfClass() {

        String[] stringList=getFarmAnimalClass().toString().split("\\.");
        int length=stringList.length;
        return stringList[length-1];

    }

    public void passTime(int days) {
        for (FarmAnimals animal : animals) {
            animal.passTime(days);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AnimalList<?>)) {
            return false;
        } else {
            return (((AnimalList) object).getFarmAnimalClass().equals(this.getFarmAnimalClass()));
        }
    }

    @Override
    public int hashCode() {
        return this.getFarmAnimalClass().hashCode();
    }


}