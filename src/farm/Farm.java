package farm;

import animals.AnimalList;
import animals.FarmAnimals;
import crops.*;
import interfaces.Display;
import interfaces.PassTime;

import java.time.LocalDate;
import java.util.ArrayList;

public class Farm implements PassTime, Display {

    private String farmName;
    private GrainList grains;
    private ArrayList<Product> products;
    private ArrayList<Crop> crops;
    private ArrayList<Tool> tools;
    private LocalDate date;
    private AnimalList animals;

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
        this.animals= new AnimalList();
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
        this.animals= new AnimalList();
    }

    public void display() {
        System.out.println("Date: " + this.date);
        System.out.println("Number of types of grains: " + this.grains.getList().toArray().length);
        System.out.println("Number of types of crops: " + this.crops.toArray().length);
        System.out.println("Number of types of products: " + this.products.toArray().length);
        System.out.println("Number of types of animals: " + this.animals.getList().toArray().length);
        System.out.println("Number of tools: " + this.tools.toArray().length);
    }

    public void displayGrains() {
        System.out.println("Date:"+getDate()+" - Grains in stock:");
        for (Farm2 grain: grains.getList()){
            System.out.println(grain);
        }
        System.out.println("-------");
    }
    public void displayAnimals() {
        System.out.println("Date:"+getDate()+" - Animals in farm:");
        for (FarmAnimals animal: animals.getList()){
            System.out.println(animal);
        }
        System.out.println("-------");
    }
    public void displayCrops() {
        System.out.println("Date:"+getDate()+" - Crops in stock:");
        for (Crop crop: crops){
            System.out.println(crop);
        }
        System.out.println("-------");
    }
    public void displayProducts() {
        System.out.println("Date:"+getDate()+" - Products in stock:");
        for (Product product: products){
            System.out.println(product);
        }
        System.out.println("-------");
    }
    public void displayTools() {
        System.out.println("Date:"+getDate()+" - Tools in farm:");
        for (Tool tool: tools){
            System.out.println(tool);
        }
        System.out.println("-------");
    }


    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }
    public void setGrains(GrainList grains) {
        this.grains = grains;
    }
    public void setProducts( ArrayList<Product> products) {
        this.products = products;
    }
    public void setCrops( ArrayList<Crop> crops) {
        this.crops = crops;
    }
    public void setTools( ArrayList<Tool> tools) {
        this.tools = tools;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setAnimals( AnimalList animals) {
        this.animals = animals;
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
    public AnimalList getAnimals() {
        return this.animals;
    }

    public void addGrain(Farm2 grain) {
        this.grains.add(grain);
    }
    public void addCrop(Crop crop) {
        this.crops.add(crop);
    }
    public void addProduct(Product product) {
        this.products.add(product);
    }
    public void addAnimal(FarmAnimals animal) {
        this.animals.add(animal);
    }
    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    @Override
    public  void passTime(int days) {
        this.date=this.date.plusDays(days);

        for (Crop crop: crops){
            crop.passTime(days);
        }
        for (Product product: products){
            product.passTime(days);
        }
        for (FarmAnimals animal: animals.getList()){
            animal.passTime(days);
        }
        for (Tool tool: tools){
            tool.passTime(days);
        }
    }

    public  void sowAllGrains() {
        for (Farm2 grain: grains.getList()){
            if (grain.getQuantity()>0) {
                Crop crop = new Crop(grain);
                addCrop(crop);
            }
        }
    }
    public  void harvestAllCrops() {
        for (Crop crop: crops){
            if (crop.getGrowthPercentage()>=100) {
                Product product = new Product(crop);
                addProduct(product);
                crop.setGrowthPercentage(0F);
            }
        }
    }

    public  void harvestCrop(Crop crop, float price) {
        if (crop.getGrowthPercentage()>=100) {
            Product product = new Product(crop);
            product.setPrice(price);
            addProduct(product);
        }
    }

    public Product findProduct(Product product1) {
        for (Product product: products){
            if(product.getName().equals(product1.getName())){
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
    public  Float sell(Product product, int quantity) {
        Product foundProduct=findProduct(product);
        if (foundProduct.equals(null)){
            System.out.println("crops.Product "+product.getName()+" not in stock");
            return 0F;
        }else if (foundProduct.getQuantity()<quantity){
            System.out.println("crops.Product "+product.getName()+" without enough stock");
            System.out.println("Only "+product.getQuantity()+" in stock, unable to sell "+quantity);
            return 0F;
        }else if(foundProduct.getRottenPercentage()>=100){
            System.out.println("crops.Product "+product.getName()+" it's rotten, unable to sell.");
            System.out.println("The product will be automatically removed from the system.");
            products.remove(foundProduct);
            return 0F;
        }else{
            System.out.println(product.getName()+" successfully sold for "+product.getSellPrice()*quantity);
            product.addQuantity(-quantity);
            return product.getSellPrice()*quantity;
        }
    }

}