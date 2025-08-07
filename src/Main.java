import animals.*;
import crops.*;
import farm.*;

import interfaces.Buy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Farm farm = new Farm();
        BankAccount bankAccount = new BankAccount("Bank", 1234, 2000F, "Income");
        FarmAccount account = new FarmAccount(farm,bankAccount);
        account.display();

        Tool tool =new Tool("Pitchfork",40);
        account.buyItem(tool);
        System.out.println(tool);
        System.out.println("-------");

        Grain carrotSeeds = new Grain("Carrots", 100,0.1F);
        account.buyItem(carrotSeeds);

        farm.sowAllGrains();
        System.out.println("Date:" + farm.getDate() + " carrots sown");
        farm.passTime(30);

        Grain cornSeed = new Grain("Corn", 200, 0.2F);
        Grain riceSeed = new Grain("Rice", 300, 0.1F);
        account.buyItem(cornSeed);
        account.buyItem(riceSeed);
        farm.sowAllGrains();
        System.out.println("Date:" + farm.getDate() + " corn and rice sown");
        System.out.println("-------");

        farm.passTime(10);
        farm.displayCrops();

        farm.passTime(70);
        farm.displayCrops();

        farm.harvestAllCrops();
        System.out.println("HARVEST");
        farm.displayCrops();
        farm.displayProducts();

        farm.passTime(20);
        farm.harvestAllCrops();
        System.out.println("HARVEST");
        farm.displayCrops();
        farm.displayProducts();

        System.out.println("SELL PRODUCTS");
        System.out.println("30 carrots sold.");
        Product product = farm.getProducts().get(0);
        product.setSellPrice(1F);
        float cash = farm.sell(product, 30);
        bankAccount.addBalance(cash);
        bankAccount.shortDisplay();
        farm.displayProducts();

        System.out.println("ANIMALS ACQUIRED");
        AnimalFeed chickenFeed = new AnimalFeed("chicken feed", 0.9F, 0.1F, "kg");
        AnimalFeed cowFeed = new AnimalFeed("cattle feed", 1000, 15F, "kg");
        AnimalFood egg = new AnimalFood("egg", 0, 1, "units");
        AnimalFood milk = new AnimalFood("milk", 0, 20, "liters");
        FarmAnimals chickens = new Poultry("chickens", 10, egg, chickenFeed);
        FarmAnimals cows = new Livestock("cows", 2, milk, cowFeed);
        chickens.setPrice(20F);
        cows.setPrice(600F);

        account.buyItem(chickens);
        account.buyItem(cows);
        farm.displayAnimals();

        farm.passTime(5);
        farm.displayAnimals();
        farm.displayProducts();

        farm.passTime(5);
        System.out.println("Date:" + farm.getDate());
        System.out.println(tool);
    }

}