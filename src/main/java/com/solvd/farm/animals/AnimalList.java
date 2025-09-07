package com.solvd.farm.animals;

import com.solvd.farm.abstracts.AbstractList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class AnimalList<T extends FarmAnimals> extends AbstractList {
    public static final Logger LOGGER = LogManager.getLogger(AnimalList.class);
    private final ArrayList<T> animals = new ArrayList<>();
    private final Class<T> farmAnimalClass;

    public AnimalList(Class<T> farmAnimalClass) {
        this.farmAnimalClass = farmAnimalClass;
    }

    public Class<T> getFarmAnimalClass() {
        return farmAnimalClass;
    }

    /* Looks in the array for the index of item with that name
        If it doesn't find it, it returns -1  */
    @Override
    public int indexOfName(String name) {

        return IntStream.range(0, animals.size())
                .filter(i -> animals.get(i).getName().equals(name))
                .findFirst()
                .orElse(-1);

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

        animals.stream()
                .forEach(LOGGER::info);
    }

    public void displayAllFeed() {
        animals.stream()
                .forEach(animal -> LOGGER.info(animal.getAnimalFeed()));
    }

    public ArrayList<T> getList() {
        return this.animals;
    }

    public String getNameOfClass() {

        String[] stringList = getFarmAnimalClass().toString().split("\\.");
        int length = stringList.length;
        return stringList[length - 1];

    }

    public void passTime(int days) {
        animals.stream()
                .forEach(animal -> animal.passTime(days));

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