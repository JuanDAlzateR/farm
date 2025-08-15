/* Last update 14/Aug/2025
I restructured the project, and implemented the interfaces.
I added Log4j and exception handling.

I started the implementation of a user menu using Scanner
 */

package com.solvd.farm;
//ensayo
import com.solvd.farm.exceptions.InvalidOptionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.farm.animals.*;
import com.solvd.farm.crops.*;
import com.solvd.farm.farm.*;
import com.solvd.farm.menu.*;

import java.util.ArrayList;
import java.util.Scanner;
//TIP To <b>interfaces.Run</b> code, press <shortcut actionId="interfaces.Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

//        LOGGER.info("This is info message");

        AllMenus menu = new AllMenus();

        Scanner scanner=menu.getScanner();
        try {
            menu.getMainMenu().run();
        }catch (InvalidOptionException e){
            LOGGER.warn("invalid option input.");
        }
        scanner.close();

    }

    /* This method is just an example of the functionality if the code,
    right now it's not called in main.
    Maybe later it could be implemented in an automated test or something similar
     */
    public static void example(){

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