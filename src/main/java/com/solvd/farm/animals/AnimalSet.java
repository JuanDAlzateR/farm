package com.solvd.farm.animals;

import java.util.LinkedHashSet;

public class AnimalSet {

    private final LinkedHashSet<AnimalList> animalTypes = new LinkedHashSet<>();

    public AnimalSet() {
        AnimalList<Aquaculture> aquacultureAnimalList = new AnimalList<>(Aquaculture.class);
        AnimalList<Equines> equinesAnimalList = new AnimalList<>(Equines.class);
        AnimalList<Livestock> livestockAnimalList = new AnimalList<>(Livestock.class);
        AnimalList<Others> othersAnimalList = new AnimalList<>(Others.class);
        AnimalList<Poultry> poultryAnimalList = new AnimalList<>(Poultry.class);

        animalTypes.add(aquacultureAnimalList);
        animalTypes.add(equinesAnimalList);
        animalTypes.add(livestockAnimalList);
        animalTypes.add(poultryAnimalList);
        animalTypes.add(othersAnimalList);

    }

    public LinkedHashSet<AnimalList> getAnimalTypes() {
        return animalTypes;
    }

    public void display() {
        animalTypes.stream()
                .forEach(AnimalList::display);
    }

    public <T extends FarmAnimals> void addAnimal(FarmAnimals animal) {
        Class<T> animalClass = (Class<T>) animal.getClass();
        animalTypes.stream()
                .filter((animalList) -> animalList.getFarmAnimalClass().equals(animalClass))
                .forEach(animalList -> animalList.add(animal));

    }

    public int size() {
        return animalTypes.stream()
                .mapToInt(animalList -> animalList.getList().size())
                .sum();
    }

    public void displayAllFeed() {
        animalTypes.stream()
                .forEach(AnimalList::displayAllFeed);
    }

    public void passTime(int days) {
        animalTypes.stream()
                .forEach(animalList -> animalList.passTime(days));
    }

}
