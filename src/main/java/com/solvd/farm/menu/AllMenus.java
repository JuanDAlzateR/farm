package com.solvd.farm.menu;

import com.solvd.farm.animals.*;
import com.solvd.farm.crops.Grain;
import com.solvd.farm.exceptions.InvalidOptionException;
import com.solvd.farm.farm.*;

import java.util.Scanner;

public class AllMenus {

    public static Scanner scanner;
    static MenuAction mainMenu;
    static FarmList farmList = new FarmList();
    static BankAccountList bankAccountList = new BankAccountList();
    static FarmAccount farmAccount;

    public AllMenus() {
        Farm farm = new Farm();
        BankAccount bankAccount = new BankAccount("Bank", 1234, 2000F, "Income");
        farmAccount = new FarmAccount(farm, bankAccount);
        farmList.add(farm);
        bankAccountList.add(bankAccount);

        Scanner scanner = new Scanner(System.in);
        setScanner(scanner);

        //First create all the menus, with just the name
        MenuAction mainMenu = new MenuAction("MAIN MENU");
        setMainMenu(mainMenu);
        MenuAction chooseFarmMenu = new MenuAction("CHOOSE FARM");
        MenuAction adminAccountsMenu = new MenuAction("ADMIN BANK ACCOUNTS");
        MenuAction adminFarmMenu = new MenuAction("ADMIN FARM");

        MenuAction buyMenu = new MenuAction("BUY ITEMS");
//        MenuAction adminCropsMenu = new MenuAction("ADMIN CROPS");
//        MenuAction adminAnimalsMenu = new MenuAction("ADMIN FARM ANIMALS");
//        MenuAction sellMenu = new MenuAction("SELL PRODUCTS");

        MenuAction buyAnimalMenu = new MenuAction("BUY ANIMALS");

        //Now, define each menu, with the options and the actions

        //Main Menu
        mainMenu.add("Quit or Exit", AllActions::exit);
        mainMenu.add("Create/Choose Farm", chooseFarmMenu);
        mainMenu.add("Create/Choose Bank Account", adminAccountsMenu);
        mainMenu.add("Admin Farm", adminFarmMenu);

        //Choose Farm Menu
        chooseFarmMenu.add("Back to previous menu", mainMenu);
        chooseFarmMenu.add("Create Farm", AllActions::addFarm);
        chooseFarmMenu.add("Choose Default Farm", AllActions::setDefaultFarm);
        chooseFarmMenu.add("Edit Farm", AllActions::editFarm);
        chooseFarmMenu.add("Display all farms", AllActions::displayFarms);

        //Admin Accounts Menu
        adminAccountsMenu.add("Back to previous menu", mainMenu);
        adminAccountsMenu.add("Create Bank Account", AllActions::addBankAccount);
        adminAccountsMenu.add("Choose Default Bank Account", AllActions::setDefaultBankAccount);
        adminAccountsMenu.add("Edit Bank Account", AllActions::editBankAccount);
        adminAccountsMenu.add("Display all bank accounts", AllActions::displayBankAccounts);
        adminAccountsMenu.add("Display accounts balance", AllActions::displayAccountsBalance);

        //Admin Farm Menu
        adminFarmMenu.add("Back to previous menu", mainMenu);
        adminFarmMenu.add("Buy Items/Animals", buyMenu);

        //I haven't implemented some features in the menu, I hope to finish this for the next week
//        adminFarmMenu.add("*Admin Crops",AllActions::editarAnimal);
//        adminFarmMenu.add("*Admin Animals",AllActions::eliminarAnimal);
//        adminFarmMenu.add("*Sell Products",AllActions::eliminarAnimal);

        //Buy Items Menu
        buyMenu.add("Back to previous menu", adminFarmMenu);
        buyMenu.add("Buy Tool", AllActions.buyItemAction(Tool.class));
        //buyMenu.add("*Buy Animal Feed ",AllActions::buyAnimalFeed);
        buyMenu.add("Buy Animal", buyAnimalMenu);
        buyMenu.add("Buy Grain", AllActions.buyItemAction(Grain.class));
        buyMenu.add("Display all tools", AllActions::displayTools);
        //buyMenu.add("*Display all animal feed in stock",AllActions::displayBankAccounts);
        buyMenu.add("Display all animals", AllActions::displayAnimals);
        buyMenu.add("Display all grains", AllActions::displayGrains);

        //Buy Animal Menu
        buyAnimalMenu.add("Back to previous menu", buyMenu);
        buyAnimalMenu.add("Aquaculture", AllActions.buyAnimalAction(Aquaculture.class));
        buyAnimalMenu.add("Equines", AllActions.buyAnimalAction(Equines.class));
        buyAnimalMenu.add("Livestock", AllActions.buyAnimalAction(Livestock.class));
        buyAnimalMenu.add("Poultry", AllActions.buyAnimalAction(Poultry.class));
        buyAnimalMenu.add("Others", AllActions.buyAnimalAction(Others.class));

    }

    public Scanner getScanner() {
        return scanner;
    }

    public MenuAction getMainMenu() {
        return mainMenu;
    }

    public FarmAccount getFarmAccount() {
        return farmAccount;
    }

    public static void setScanner(Scanner scanner) {
        AllMenus.scanner = scanner;
    }

    public static void setMainMenu(MenuAction mainMenu) {
        AllMenus.mainMenu = mainMenu;
    }

    public void runMainMenu() throws InvalidOptionException {
        try {
            getMainMenu().run();
        } catch (InvalidOptionException e) {
            getMainMenu().run();
        }
    }

    public void updateDefaults() {
        String defaultFarmName = AllMenus.farmAccount.getFarm().getFarmName();
        int farmIndex = farmList.indexOfName(defaultFarmName);
        farmList.setDefaultFarmIndex(farmIndex);

        int defaultAccountNumber = AllMenus.farmAccount.getBankAccount().getAccountNumber();
        int accountIndex = bankAccountList.indexOf(defaultAccountNumber);
        bankAccountList.setDefaultAccountIndex(accountIndex);
    }

}