package com.solvd.farm.abstracts;

public abstract class Purchasable extends Countable {

    private float pricePer1Unit;
    private String currency;

    public Purchasable() {
        super("New name", 0);
        this.pricePer1Unit = 0;
        this.currency = "usd";
    }

    public Purchasable(String name, float quantity) {
        super(name, quantity);
        this.pricePer1Unit = 0;
        this.currency = "usd";
    }

    public Purchasable(String name, float quantity, float price) {
        super(name, quantity);
        this.pricePer1Unit = price;
        this.currency = "usd";
    }

    public void setPrice(float price) {
        this.pricePer1Unit = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getPrice() {
        return this.pricePer1Unit;
    }

    public String getCurrency() {
        return this.currency;
    }
}