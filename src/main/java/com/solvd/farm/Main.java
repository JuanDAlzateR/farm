/* Last update 21/Aug/2025
I changed all system.outs for logger
I implemented generics and collections

 */

package com.solvd.farm;

import com.solvd.farm.exceptions.InvalidOptionException;
import com.solvd.farm.animals.*;
import com.solvd.farm.crops.*;
import com.solvd.farm.farm.*;
import com.solvd.farm.menu.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//TIP To <b>interfaces.Run</b> code, press <shortcut actionId="interfaces.Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        AllMenus menu = new AllMenus();

        //Scanner scanner = menu.getScanner();

        try {
            menu.runMainMenu();
        } catch (InvalidOptionException e) {
            LOGGER.warn("error");
        }

    }

    /* This method is just an example of the functionality in the code.
    It can be called in the main menu as EXAMPLE: TEST FARM METHODS
     */
    public static void example(FarmAccount account) {

        Farm farm = account.getFarm();
        BankAccount bankAccount = account.getBankAccount();
        account.display();

        Tool tool = new Tool("Pitchfork", 40);
        account.buyItem(tool);
        LOGGER.info(tool);
        LOGGER.info(tool);
        LOGGER.info("-------");

        Grain carrotSeeds = new Grain("Carrots", 100, 0.1F);
        account.buyItem(carrotSeeds);

        farm.sowAllGrains();
        LOGGER.info("Date:" + farm.getDate() + " carrots sown");
        farm.passTime(30);

        Grain cornSeed = new Grain("Corn", 200, 0.2F);
        Grain riceSeed = new Grain("Rice", 300, 0.1F);
        account.buyItem(cornSeed);
        account.buyItem(riceSeed);
        farm.sowAllGrains();
        LOGGER.info("Date:" + farm.getDate() + " corn and rice sown");
        LOGGER.info("-------");

        farm.passTime(10);
        farm.displayCrops();

        farm.passTime(70);
        farm.displayCrops();

        farm.harvestAllCrops();
        LOGGER.info("HARVEST");
        farm.displayCrops();
        farm.displayProducts();

        farm.passTime(20);
        farm.harvestAllCrops();
        LOGGER.info("HARVEST");
        farm.displayCrops();
        farm.displayProducts();

        LOGGER.info("SELL PRODUCTS");
        LOGGER.info("30 carrots sold.");
        Product product = farm.getProducts().getList().get(0);
        product.setSellPrice(1F);
        float cash = farm.sell(product, 30);
        bankAccount.addBalance(cash);
        bankAccount.shortDisplay();
        farm.displayProducts();

        LOGGER.info("ANIMALS ACQUIRED");
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
        LOGGER.info("Date:" + farm.getDate());
        LOGGER.info(tool);

//        AllActions.buyAnimalFeed();
//        AllActions.displayAnimalFeed();

    }
}