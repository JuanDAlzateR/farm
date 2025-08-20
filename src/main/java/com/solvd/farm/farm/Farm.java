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
    private GrainList grains;
    private ArrayList<Product> products;
    private ArrayList<Crop> crops;
    private ArrayList<Tool> tools;
    private LocalDate date;
    private AllAnimals allAnimals;

    public Farm() {
        GrainList grains = new GrainList();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Crop> crops = new ArrayList<>();
        ArrayList<Tool> tools = new ArrayList<>();
        this.grains = grains;
        this.products = products;
        this.crops = crops;
        this.tools = tools;
        this.date = LocalDate.now();
        this.allAnimals = new AllAnimals();
        this.farmName = "New Farm";
    }

    public Farm(String farmName) {
        GrainList grains = new GrainList();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Crop> crops = new ArrayList<>();
        ArrayList<Tool> tools = new ArrayList<>();
        this.grains = grains;
        this.products = products;
        this.crops = crops;
        this.date = LocalDate.now();
        this.allAnimals = new AllAnimals();
        this.farmName = farmName;
    }

    public Farm(LocalDate date) {
        GrainList grains = new GrainList();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Crop> crops = new ArrayList<>();
        ArrayList<Tool> tools = new ArrayList<>();
        this.grains = grains;
        this.products = products;
        this.crops = crops;
        this.date = date;
        this.allAnimals = new AllAnimals();
        this.farmName = "New Farm";
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public void setGrains(GrainList grains) {
        this.grains = grains;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setCrops(ArrayList<Crop> crops) {
        this.crops = crops;
    }

    public void setTools(ArrayList<Tool> tools) {
        this.tools = tools;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAnimals(AllAnimals allAnimals) {
        this.allAnimals = allAnimals;
    }

    public String getFarmName() {
        return farmName;
    }

    public GrainList getGrains() {
        return this.grains;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public ArrayList<Crop> getCrops() {
        return this.crops;
    }

    public ArrayList<Tool> getTools() {
        return this.tools;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public AllAnimals getAllAnimals() {
        return this.allAnimals;
    }

    public void display() {
        LOGGER.info("Date: " + this.date);
        LOGGER.info("Number of types of grains: " + this.grains.getList().toArray().length);
        LOGGER.info("Number of types of crops: " + this.crops.toArray().length);
        LOGGER.info("Number of types of products: " + this.products.toArray().length);
        LOGGER.info("Number of types of animals: " + this.allAnimals.size());
        LOGGER.info("Number of tools: " + this.tools.toArray().length);
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
        allAnimals.display();
        LOGGER.info("-------");
    }

    public void displayCrops() {
        LOGGER.info("Date:" + getDate() + " - Crops in stock:");
        for (Crop crop : crops) {
            LOGGER.info(crop);
        }
        LOGGER.info("-------");
    }

    public void displayProducts() {
        LOGGER.info("Date:" + getDate() + " - Products in stock:");
        for (Product product : products) {
            LOGGER.info(product);
        }
        LOGGER.info("-------");
    }

    public void displayTools() {
        LOGGER.info("");
        LOGGER.info("Date:" + getDate() + " - Tools in farm:");
        for (Tool tool : tools) {
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
        this.allAnimals.addAnimal(animal);
    }

    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    @Override
    public void passTime(int days) {
        this.date = this.date.plusDays(days);

        for (Crop crop : crops) {
            crop.passTime(days);
        }
        for (Product product : products) {
            product.passTime(days);
        }
        for (Tool tool : tools) {
            tool.passTime(days);
        }
        allAnimals.passTime(days);
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
        for (Crop crop : crops) {
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
        for (Product product : products) {
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
            products.remove(foundProduct);
            return 0F;
        } else {
            LOGGER.info(product.getName() + " successfully sold for " + product.getSellPrice() * quantity);
            product.addQuantity(-quantity);
            return product.getSellPrice() * quantity;
        }
    }

}