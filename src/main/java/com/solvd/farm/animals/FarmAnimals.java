package com.solvd.farm.animals;

import com.solvd.farm.abstracts.Purchasable;
import com.solvd.farm.farm.Farm;
import com.solvd.farm.interfaces.IPassTime;
import com.solvd.farm.interfaces.IBuy;

public abstract class FarmAnimals extends Purchasable implements IPassTime, IBuy {

    private AnimalFood animalFood;
    private AnimalFeed animalFeed;

    public FarmAnimals() {
        super("New animal", 0);
        this.animalFood = new AnimalFood();
        this.animalFeed = new AnimalFeed();
    }

    public FarmAnimals(String name, int quantity, AnimalFood animalFood, AnimalFeed animalFeed) {
        super(name, quantity);
        this.animalFood = animalFood;
        this.animalFeed = animalFeed;
    }

    @Override
    public String toString() {
        String line = (this.getQuantity() + " " + this.getName() + " | " +
                this.animalFeed.getName() + ": %.2f " + this.animalFeed.getFeedUnit() + " | " +
                this.animalFood.getName() + ": %.1f " + this.animalFood.getProductionUnit());
        return String.format(line, this.animalFeed.getQuantity(), this.animalFood.getQuantity());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FarmAnimals)) {
            return false;
        } else if (((FarmAnimals) o).getName().equals(this.getName())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    public void setAnimalFood(AnimalFood Rate) {
        this.animalFood = Rate;
    }
    public void setAnimalFeed(AnimalFeed Percentage) {
        this.animalFeed = Percentage;
    }
    public void setAnimal(String name, int quantity, AnimalFood animalFood, AnimalFeed animalFeed) {
        this.setName(name);
        this.setQuantity(quantity);
        this.animalFood=animalFood;
        this.animalFeed = animalFeed;
    }

    public AnimalFood getAnimalFood() {
        return this.animalFood;
    }
    public AnimalFeed getAnimalFeed() {
        return this.animalFeed;
    }

    @Override
    public void passTime(int days) {
        this.animalFood.produce(days);
        this.animalFeed.consume(days);
    }

    @Override
    public void addToFarm(Farm farm) {
        farm.addAnimal(this);
    }

}