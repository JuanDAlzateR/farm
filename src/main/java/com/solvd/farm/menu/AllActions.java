package com.solvd.farm.menu;

import com.solvd.farm.Main;
import com.solvd.farm.animals.*;
import com.solvd.farm.farm.*;
import com.solvd.farm.input.*;
import com.solvd.farm.interfaces.IBuy;
import com.solvd.farm.interfaces.IMenuAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AllActions {

    public static final Logger LOGGER = LogManager.getLogger(AllActions.class);

    // Methods for the menu actions
    public static void addFarm() {
        String farmName = inputString("Please type the name of the farm");
        Farm farm = new Farm(farmName);
        AllMenus.farmList.add(farm);

    }

    public static void setDefaultFarm() {
        AllMenus.farmList.displayWithIndex();
        int index = inputInt("Please type the number of the farm to set as default");
        AllMenus.farmList.setDefaultFarmIndex(index);
        Farm defaultFarm = AllMenus.farmList.getDefaultFarm();
        AllMenus.farmAccount.setFarm(defaultFarm);
        AllMenus.farmList.displayWithIndex();

    }

    public static void editFarm() {
        AllMenus.farmList.displayWithIndex();
        int index = inputInt("Please type the number of the farm to edit");
        Farm farm = AllMenus.farmList.getList().get(index);
        String farmName = inputString("Please type the new name of the farm");
        farm.setFarmName(farmName);

    }

    public static void displayFarms() {
        AllMenus.farmList.display();

    }

    // Methods for the bank account menu
    public static void addBankAccount() {
        String bankName = inputName("Please type the name of the bank");
        int accountNumber = inputInt("Please type the account number");
        float balance = inputFloat("Please type the account balance");
        String nickName = inputString("Please type the account nickname");

        BankAccount bankAccount = new BankAccount(bankName, accountNumber, balance, nickName);
        AllMenus.bankAccountList.add(bankAccount);

    }

    public static void setDefaultBankAccount() {
        AllMenus.bankAccountList.display(true);
        int index = inputInt("Please type the option number of the bank account to set as default");
        AllMenus.bankAccountList.setDefaultAccountIndex(index);
        BankAccount defaultAccount = AllMenus.bankAccountList.getList().get(index);
        AllMenus.farmAccount.setBankAccount(defaultAccount);

    }

    public static void editBankAccount() {
        AllMenus.bankAccountList.display(true);

        int index = inputInt("Please type the option number of the bank account to edit");
        BankAccount bankAccount = AllMenus.bankAccountList.getList().get(index);

        LOGGER.info("Bank (not editable): " + bankAccount.getBankName());
        LOGGER.info("Account number (not editable): " + bankAccount.getAccountNumber());

//        String bankName = inputName("Current bank: " + bankAccount.getBankName() + ". Please type the new name of the bank");
//        int accountNumber = inputInt("Current Account number: " + bankAccount.getAccountNumber() + ". Please type the account number");
        float balance = inputFloat("Current balance: " + bankAccount.getBalance() + ". Please type the account balance");
        String nickName = inputString("Current nickname: " + bankAccount.getNickname() + ". Please type the account nickname");

        bankAccount.setBalance(balance);
        bankAccount.setNickname(nickName);

    }

    public static void displayBankAccounts() {
        AllMenus.bankAccountList.display(false);

    }

    public static void displayAccountsBalance() {
        AllMenus.bankAccountList.displayWithBalance();

    }

    public static void buyItem(IBuy item) {
        AllMenus.farmAccount.getBankAccount().display();

        String itemName = inputName("Please type the name of the item to buy:");
        float quantity = inputFloat("Please type how many " + itemName + " you want to buy :");
        float price = inputFloat("Please type the price of" + itemName + "for 1 unit :");
        item.setName(itemName);
        item.setQuantity(quantity);
        item.setPrice(price);
        AllMenus.farmAccount.buyItem(item);

    }

    public static <T extends IBuy> IMenuAction buyItemAction(Class<T> itemClass) {
        IMenuAction act = () -> {
            T item = createItem(itemClass);
            buyItem(item);
        };
        return act;
    }

    public static <T extends IBuy> T createItem(Class<T> itemClass) {

        try {
            //creations of the new item
            return itemClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Item not created" + e.getMessage(), e);
        }
    }

    public static void buyAnimalFeed() {
        AllMenus.farmAccount.getFarm().getAnimalSet().displayAllFeed();

        String feedName = inputName("Please type the name of the animal feed:");
        String feedUnit = inputMeasurementUnit("Please type the unit of " + feedName + " :");
        float quantity = inputFloat("Please type how many " + feedUnit + " you want to buy :");
        float price = inputFloat("Please type the price of" + feedName + " for 1 " + feedUnit + " :");
        float consumptionRate = inputFloat("What is the consumption of" + feedName + "for an animal per day:");

        AnimalFeed animalFeed = new AnimalFeed(feedName, quantity, consumptionRate, feedUnit);
        animalFeed.setPrice(price);
        AllMenus.farmAccount.buyItem(animalFeed);

    }

    public static void buyAnimal(FarmAnimals animal) {
        //displayAnimals(null);

        String animalName = inputName("Please type the name of the animal to buy:");
        int quantity = inputInt("Please type how many " + animalName + " you want to buy :");
        float price = inputFloat("Please type the price of " + animalName + " for only 1 animal :");

        //Temporary implementation, uses default animalFeed and animalFood it needs to change.
        AnimalFeed animalFeed = new AnimalFeed();
        animalFeed.setQuantity(10);
        AnimalFood animalFood = new AnimalFood();
        animalFood.setQuantity(10);

        animal.setAnimal(animalName, quantity, animalFood, animalFeed);
        animal.setPrice(price);
        AllMenus.farmAccount.buyItem(animal);

    }

    public static <T extends FarmAnimals> T createAnimal(Class<T> animalClass) {
        //Temporary implementation, uses default animalFeed and animalFood it needs to change.
        AnimalFeed animalFeed = new AnimalFeed();
        animalFeed.setQuantity(10);
        AnimalFood animalFood = new AnimalFood();
        animalFood.setQuantity(10);

        try {
            //creations of the new animal
            return animalClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Animal not created" + e.getMessage(), e);
        }
    }

    public static <T extends FarmAnimals> IMenuAction buyAnimalAction(Class<T> animalClass) {
        IMenuAction act = () -> {
            FarmAnimals animal;
            animal = createAnimal(animalClass);
            buyAnimal(animal);

        };
        return act;
    }

    public static void displayTools() {
        AllMenus.farmAccount.getFarm().displayTools();
    }

    public static void displayAnimalFeed() {
        AllMenus.farmAccount.getFarm().getAnimalSet().displayAllFeed();
    }

    public static void displayAnimals() {
        AllMenus.farmAccount.getFarm().getAnimalSet().display();
    }

    public static void displayGrains() {
        AllMenus.farmAccount.getFarm().getGrains().display();
    }

//    public static void editAnimal() {
//        LOGGER.info("Edit animal...");
//
//    }
//
//    public static void eliminateAnimal() {
//        LOGGER.info("Eliminate animal...");
//
//    }

    public static void exit() {
        LOGGER.info("Closing...");
        System.exit(0);

    }

    public static String inputString(String message) {
        LOGGER.info(message);
        return AllMenus.scanner.nextLine();

    }

    public static <T> T genericInput(Class<T> tClass, String string, Object defaul) {
        try {
            return Input.input(tClass, string);
        } catch (Exception e) {
            LOGGER.warn("generic input error | class " + tClass + "| string " + string);
        }
        return (T) defaul;
    }

    public static int inputInt(String message) {
        return genericInput(int.class, message, -1);
    }

    public static float inputFloat(String message) {
        return genericInput(float.class, message, -1);
    }

    public static String inputName(String message) {
        return (genericInput(NameString.class, message, "")).getName();
    }

    public static String inputMeasurementUnit(String message) {
        return (genericInput(UnitMeasureString.class, message, "")).getUnitMeasure();
    }

    public static void testFarmMethods() {
        Main.example(AllMenus.farmAccount);
    }
}