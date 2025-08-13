package com.solvd.farm.menu;

import com.solvd.farm.animals.*;
import com.solvd.farm.farm.*;

public class AllActions {
    //static Scanner scanner;

    // Methods for the menu actions
    public static Object[] addFarm(Object[] params) {
        String farmName = inputString("Please type the name of the farm");
        Farm farm=new Farm(farmName);
        AllMenus.farmList.add(farm);
        return null;
    }

    public static Object[] setDefaultFarm(Object[] params) {
        AllMenus.farmList.displayWithIndex();
        int index =inputInt("Please type the number of the farm to set as default");
        AllMenus.farmList.setDefaultFarmIndex(index);
        Farm defaultFarm=AllMenus.farmList.getDefaultFarm();
        AllMenus.farmAccount.setFarm(defaultFarm);
        return null;
    }

    public static Object[] editFarm(Object[] params) {
        AllMenus.farmList.displayWithIndex();
        int index = inputInt("Please type the number of the farm to edit");
        Farm farm =AllMenus.farmList.getList().get(index);
        String farmName = inputString("Please type the new name of the farm");
        farm.setFarmName(farmName);
        return null;
    }

    public static Object[] displayFarms(Object[] params) {
        AllMenus.farmList.display();
        return null;
    }

    // Methods for the bank account menu
    public static Object[] addBankAccount(Object[] params) {
        String bankName =inputString("Please type the name of the bank");
        int accountNumber = inputInt("Please type the account number");
        float balance = inputFloat("Please type the account balance");
        String nickName =inputString("Please type the account nickname");

        BankAccount bankAccount=new BankAccount(bankName,accountNumber,balance,nickName);
        AllMenus.bankAccountList.add(bankAccount);
        return null;
    }

    public static Object[] setDefaultBankAccount(Object[] params) {
        AllMenus.bankAccountList.displayWithIndex();
        int index = inputInt("Please type the option number of the bank account to set as default");
        AllMenus.bankAccountList.setDefaultAccountIndex(index);
        BankAccount defaultAccount=AllMenus.bankAccountList.getList().get(index);
        AllMenus.farmAccount.setBankAccount(defaultAccount);
        return null;
    }

    public static Object[] editBankAccount(Object[] params) {
        AllMenus.bankAccountList.displayWithIndex();

        int index = inputInt("Please type the option number of the bank account to edit");
        BankAccount bankAccount=AllMenus.bankAccountList.getList().get(index);

        String bankName = inputString("Current bank: "+bankAccount.getBankName()+". Please type the new name of the bank");
        int accountNumber = inputInt("Current Account number: "+bankAccount.getAccountNumber()+". Please type the account number");
        float balance = inputFloat("Current balance: "+bankAccount.getBalance()+". Please type the account balance");
        String nickName = inputString("Current nickname: "+bankAccount.getNickname()+". Please type the account nickname");

        bankAccount.setBankName(bankName);
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setBalance(balance);
        bankAccount.setNickname(nickName);

        return null;
    }

    public static Object[] displayBankAccounts(Object[] params) {
        AllMenus.bankAccountList.display();
        return null;
    }

    public static Object[] buyTool(Object[] params) {
        AllMenus.farmAccount.getBankAccount().display();

        String toolName = inputString("Please type the name of the tool:");
        float price = inputFloat("Please type the price of the tool:");
        Tool tool=new Tool(toolName,price);
        AllMenus.farmAccount.buyItem(tool);

        return null;
    }

    //Syntax reminders ;)
    //AnimalFeed chickenFeed = new AnimalFeed("chicken feed", 0.9F, 0.1F, "kg");
    public static Object[] buyAnimalFeed(Object[] params) {
        AllMenus.farmAccount.getFarm().getAnimals().displayAllFeed();

        String feedName = inputString("Please type the name of the animal feed:");
        String feedUnit = inputString("Please type the unit of "+feedName+" :");
        float quantity = inputFloat("Please type how many "+feedUnit+" you want to buy :");
        float price = inputFloat("Please type the price of"+feedName+"for 1" +feedUnit+" :");
        float consumptionRate = inputFloat("What is the consumption of" +feedName+ "for an animal per day:");

        AnimalFeed animalFeed=new AnimalFeed(feedName,quantity,consumptionRate,feedUnit);
        animalFeed.setPrice(price);
        AllMenus.farmAccount.buyItem(animalFeed);

        return null;
    }

    //Syntax reminders ;)
    //AnimalFood milk = new AnimalFood("milk", 0, 20, "liters");
    //FarmAnimals chickens = new Poultry("chickens", 10, egg, chickenFeed);
    public static Object[] buyAnimal(Object[] params) {
        //displayAnimals(null);

        String animalName = inputString("Please type the name of the animal to buy:");
        int quantity = inputInt("Please type how many "+animalName+" you want to buy :");
        float price = inputFloat("Please type the price of "+animalName+" for only 1 animal :");

        //Temporary implementation, uses default animalFeed and animalFood it needs to change.
        AnimalFeed animalFeed=new AnimalFeed();
        animalFeed.setQuantity(10);
        AnimalFood animalFood=new AnimalFood();
        animalFood.setQuantity(10);

        //Temporary implementation, the animal it's created as LiveStock, it needs to change be able to add it as the respective class.
        Livestock animal =new Livestock(animalName,quantity,animalFood,animalFeed);
        animal.setPrice(price);
        AllMenus.farmAccount.buyItem(animal);

        return null;
    }

    public static Object[] displayTools(Object[] params) {
        AllMenus.farmAccount.getFarm().displayTools();
        return null;
    }

    public static Object[] displayAnimalFeed(Object[] params) {
        AllMenus.farmAccount.getFarm().getAnimals().displayAllFeed();
        return null;
    }

    public static Object[] displayAnimals(Object[] params) {
        AllMenus.farmAccount.getFarm().getAnimals().display();
        return null;
    }



    public static Object[] addAnimal(Object[] params) {
        System.out.println("Adding animal...");
        if ((params[0] instanceof Farm)&&(params[1] instanceof FarmAnimals)){
            ((Farm) params[0]).addAnimal((FarmAnimals) params[1]);
        }
        // lógica aquí
        return null;
    }

    public static Object[] editarAnimal(Object[] params) {
        System.out.println("Editando animal...");
        // lógica aquí
        return null;
    }

    public static Object[] eliminarAnimal(Object[] params) {
        System.out.println("Eliminando animal...");
        // lógica aquí
        return null;
    }

    public static Object[] exit(Object[] params) {
        System.out.println("Closing...");
        System.exit(0);
        return null;
    }

    public static String inputString(String message) {
        System.out.println(message);
        String input = AllMenus.scanner.nextLine();
        return input;
    }

    public static int inputInt(String message) {
        System.out.println(message);
        int input = AllMenus.scanner.nextInt();
        AllMenus.scanner.nextLine();
        return input;
    }

    public static float inputFloat(String message) {
        System.out.println(message);
        float input = AllMenus.scanner.nextFloat();
        AllMenus.scanner.nextLine();
        return input;
    }

}
