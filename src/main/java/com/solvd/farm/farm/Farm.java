package com.solvd.farm.farm;

import com.solvd.farm.animals.*;
import com.solvd.farm.crops.*;
import com.solvd.farm.interfaces.IDisplay;
import com.solvd.farm.interfaces.IPassTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;

public class Farm implements IPassTime, IDisplay {

    public static final Logger LOGGER = LogManager.getLogger(Farm.class);
    private String farmName;
    private GenericList<Grain> grains;
    private GenericList<Product> products;
    private GenericList<Crop> crops;
    private GenericList<Tool> tools;
    private LocalDate date;
    private AnimalSet animalSet;

    public Farm() {
        GenericList<Grain> grains = new GenericList();
        GenericList<Product> products = new GenericList<>();
        GenericList<Crop> crops = new GenericList<>();
        GenericList<Tool> tools = new GenericList<>();
        this.grains = grains;
        this.products = products;
        this.crops = crops;
        this.tools = tools;
        this.date = LocalDate.now();
        this.animalSet = new AnimalSet();
        this.farmName = "New Farm";
    }

    public Farm(String farmName) {
        this();
        this.farmName = farmName;
    }

    public Farm(LocalDate date) {
        this();
        this.date = date;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public void setGrains(GenericList<Grain> grains) {
        this.grains = grains;
    }

    public void setProducts(GenericList<Product> products) {
        this.products = products;
    }

    public void setCrops(GenericList<Crop> crops) {
        this.crops = crops;
    }

    public void setTools(GenericList<Tool> tools) {
        this.tools = tools;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAnimals(AnimalSet animalSet) {
        this.animalSet = animalSet;
    }

    public String getFarmName() {
        return farmName;
    }

    public GenericList<Grain> getGrains() {
        return this.grains;
    }

    public GenericList<Product> getProducts() {
        return this.products;
    }

    public GenericList<Crop> getCrops() {
        return this.crops;
    }

    public GenericList<Tool> getTools() {
        return this.tools;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public AnimalSet getAnimalSet() {
        return this.animalSet;
    }

    public void display() {
        LOGGER.info("Date: " + this.date);
        LOGGER.info("Number of types of grains: " + this.grains.getList().toArray().length);
        LOGGER.info("Number of types of crops: " + this.crops.getList().toArray().length);
        LOGGER.info("Number of types of products: " + this.products.getList().toArray().length);
        LOGGER.info("Number of types of animals: " + this.animalSet.size());
        LOGGER.info("Number of tools: " + this.tools.getList().toArray().length);
    }

    public void displayGrains() {
        LOGGER.info("Date:" + getDate() + " - Grains in stock:");
        for (Grain grain : grains.getList()) {
            LOGGER.info(grain);
        }
        LOGGER.info("-------");
    }

    public void displayAnimals() {
        LOGGER.info("Date:" + getDate() + " - Animals in farm:");
        animalSet.display();
        LOGGER.info("-------");
    }

    public void displayCrops() {
        LOGGER.info("Date:" + getDate() + " - Crops in stock:");
        for (Crop crop : crops.getList()) {
            LOGGER.info(crop);
        }
        LOGGER.info("-------");
    }

    public void displayProducts() {
        LOGGER.info("Date:" + getDate() + " - Products in stock:");
        for (Product product : products.getList()) {
            LOGGER.info(product);
        }
        LOGGER.info("-------");
    }

    public void displayTools() {
        LOGGER.info("");
        LOGGER.info("Date:" + getDate() + " - Tools in farm:");
        for (Tool tool : tools.getList()) {
            LOGGER.info(tool);
        }
        LOGGER.info("-------");
    }

    public void addGrain(Grain grain) {
        this.grains.add(grain);
    }

    public void addCrop(Crop crop) {
        this.crops.add(crop);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addAnimal(FarmAnimals animal) {
        this.animalSet.addAnimal(animal);
    }

    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    @Override
    public void passTime(int days) {
        this.date = this.date.plusDays(days);

        for (Crop crop : crops.getList()) {
            crop.passTime(days);
        }
        for (Product product : products.getList()) {
            product.passTime(days);
        }
        for (Tool tool : tools.getList()) {
            tool.passTime(days);
        }
        animalSet.passTime(days);
    }

    public void sowAllGrains() {
        for (Grain grain : grains.getList()) {
            if (grain.getQuantity() > 0) {
                Crop crop = new Crop(grain);
                addCrop(crop);
            }
        }
    }

    public void harvestAllCrops() {
        for (Crop crop : crops.getList()) {
            if (crop.getGrowthPercentage() >= 100) {
                Product product = new Product(crop);
                addProduct(product);
                crop.setGrowthPercentage(0F);
            }
        }
    }

    public void harvestCrop(Crop crop, float price) {
        if (crop.getGrowthPercentage() >= 100) {
            Product product = new Product(crop);
            product.setPrice(price);
            addProduct(product);
        }
    }

    public Product findProduct(Product product1) {
        for (Product product : products.getList()) {
            if (product.getName().equals(product1.getName())) {
                return product;
            }
        }
        return null;
    }

    /**
     * Sells the product, if it finds enough stock
     *
     * @return the amount of cash corresponding to the sale,
     * 0 if not enough stock.
     */
    public Float sell(Product product, int quantity) {
        Product foundProduct = findProduct(product);
        if (foundProduct.equals(null)) {
            LOGGER.info("crops.Product " + product.getName() + " not in stock");
            return 0F;
        } else if (foundProduct.getQuantity() < quantity) {
            LOGGER.info("crops.Product " + product.getName() + " without enough stock");
            LOGGER.info("Only " + product.getQuantity() + " in stock, unable to sell " + quantity);
            return 0F;
        } else if (foundProduct.getRottenPercentage() >= 100) {
            LOGGER.info("crops.Product " + product.getName() + " it's rotten, unable to sell.");
            LOGGER.info("The product will be automatically removed from the system.");
            products.getList().remove(foundProduct);
            return 0F;
        } else {
            LOGGER.info(product.getName() + " successfully sold for " + product.getSellPrice() * quantity);
            product.addQuantity(-quantity);
            return product.getSellPrice() * quantity;
        }
    }

}