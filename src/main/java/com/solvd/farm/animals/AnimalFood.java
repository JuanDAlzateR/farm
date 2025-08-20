package com.solvd.farm.animals;

import com.solvd.farm.abstracts.Countable;

public class AnimalFood extends Countable {

    private float productionRatePerDay;
    private String productionUnit;

    public AnimalFood() {
        super("New animal food", 0);
        this.productionRatePerDay = 0.5F;
        this.productionUnit = "new unit";
    }

    public AnimalFood(String name, float quantity, float productionRatePerDay, String productionUnit) {
        super(name, quantity);
        this.productionRatePerDay = productionRatePerDay;
        this.productionUnit = productionUnit;
    }

    @Override
    public String toString() {
        return (this.getName() + " | quantity " + this.getQuantity() + " " + this.productionUnit + " | " + this.productionRatePerDay + " produce per day");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AnimalFood)) {
            return false;
        } else if (((AnimalFood) o).getName().equals(this.getName())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    public void setProductionRatePerDay(Float Rate) {
        this.productionRatePerDay = Rate;
    }

    public void setProductionUnit(String Percentage) {
        this.productionUnit = Percentage;
    }

    public float getProductionRatePerDay() {
        return this.productionRatePerDay;
    }

    public String getProductionUnit() {
        return this.productionUnit;
    }

    public void produce(int days) {
        this.addQuantity(productionRatePerDay * days);
    }

}