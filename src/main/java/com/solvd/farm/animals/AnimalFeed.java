package com.solvd.farm.animals;

import com.solvd.farm.abstracts.*;
import com.solvd.farm.farm.Farm;
import com.solvd.farm.interfaces.IBuy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnimalFeed extends Purchasable implements IBuy {

    public static final Logger LOGGER = LogManager.getLogger(AnimalFeed.class);
    private float consumptionRatePerDay;
    private String feedUnit;

    public AnimalFeed() {
        super("New animal feed", 0);
        this.consumptionRatePerDay = 0.5F;
        this.feedUnit = "new unit";
    }

    public AnimalFeed(String name, float quantity, float consumptionRatePerDay, String feedUnit) {
        super(name, quantity);
        this.consumptionRatePerDay = consumptionRatePerDay;
        this.feedUnit = feedUnit;
    }

    @Override
    public String toString() {
        String line = (this.getName() + " | quantity %.2f " + this.feedUnit + " | " + this.consumptionRatePerDay + " consume per day%n");
        return String.format(line, this.getQuantity());
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AnimalFeed)) {
            return false;
        } else {
            return (((AnimalFeed) object).getName().equals(this.getName()));
        }
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    public void setConsumptionRatePerDay(Float Rate) {
        this.consumptionRatePerDay = Rate;
    }

    public void setFeedUnit(String Percentage) {
        this.feedUnit = Percentage;
    }

    public float getConsumptionRatePerDay() {
        return this.consumptionRatePerDay;
    }

    public String getFeedUnit() {
        return this.feedUnit;
    }

    public void consume(int days) {
        this.addQuantity(-consumptionRatePerDay * days);
        if (this.getQuantity() < 0) {
            LOGGER.info("Warning: Not enough " + getName());
            LOGGER.info(this);
            this.setQuantity(0);
        }
    }

    /*This method doesn't do anything,
    AnimalFeed will be added to the Farm, when a FarmAnimal it's added.
    */
    @Override
    public void addToFarm(Farm farm) {
    }
}