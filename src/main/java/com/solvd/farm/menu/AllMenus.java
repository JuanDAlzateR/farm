package com.solvd.farm.menu;

import com.solvd.farm.farm.*;
import com.solvd.farm.interfaces.IMenuAction;

import java.util.ArrayList;
import java.util.Scanner;

public class AllMenus {
    static Scanner scanner;
    static MenuAction mainMenu;
    static FarmList farmList=new FarmList();
    static BankAccountList bankAccountList=new BankAccountList();
    static FarmAccount farmAccount;

    public AllMenus() {
        Farm farm = new Farm();
        BankAccount bankAccount = new BankAccount("Bank", 1234, 2000F, "Income");
        FarmAccount account = new FarmAccount(farm,bankAccount);
        farmAccount=account;
        farmList.add(farm);
        bankAccountList.add(bankAccount);


        this.scanner = new Scanner(System.in);
        ArrayList<String> options = new ArrayList<>();
        ArrayList<IMenuAction> actions = new ArrayList<>();

        //First create all the menus, with just the name
        MenuAction mainMenu = new MenuAction("MAIN MENU");
        this.mainMenu=mainMenu;
        MenuAction chooseFarmMenu = new MenuAction("CHOOSE FARM");
        MenuAction adminAccountsMenu = new MenuAction("ADMIN BANK ACCOUNTS");
        MenuAction adminFarmMenu = new MenuAction( "ADMIN FARM");

        MenuAction adminAnimalsMenu = new MenuAction( "ADMIN FARM ANIMALS");

        //Now, define each menu, with the options and the actions

        //Main Menu
        mainMenu.add("Quit or Exit",AllActions::exit);
        mainMenu.add("Create/Choose Farm",chooseFarmMenu);
        mainMenu.add("Create/Choose Bank Account",adminAccountsMenu);
        mainMenu.add("Admin Farm",adminFarmMenu);

        //Choose Farm Menu
        chooseFarmMenu.add("Back to previous menu",mainMenu);
        chooseFarmMenu.add("Create Farm",AllActions::newFarm);
        chooseFarmMenu.add("Choose Default Farm",AllActions::editarAnimal);
        chooseFarmMenu.add("Edit Farm",AllActions::eliminarAnimal);
        chooseFarmMenu.add("Display all farms",AllActions::eliminarAnimal);

        //Admin Accounts Menu
        adminAccountsMenu.add("Back to previous menu",mainMenu);
        adminAccountsMenu.add("Create Bank Account",(params) -> AllActions.addAnimal(params));
        adminAccountsMenu.add("Choose Default Bank Account",AllActions::editarAnimal);
        adminAccountsMenu.add("Edit Bank Account",AllActions::eliminarAnimal);
        adminAccountsMenu.add("Display all farms",AllActions::eliminarAnimal);

        //Admin Farm Menu
        adminFarmMenu.add("Back to previous menu",mainMenu);
        adminFarmMenu.add("Buy Items/Animals",(params) -> AllActions.addAnimal(params));
        adminFarmMenu.add("Admin Crops",AllActions::editarAnimal);
        adminFarmMenu.add("Admin Animals",AllActions::eliminarAnimal);
        adminFarmMenu.add("Sell Products",AllActions::eliminarAnimal);

    }

    public Scanner getScanner() {
        return scanner;
    }
    public MenuAction getMainMenu() {
        return mainMenu;
    }

    public void runMainMenu(){
        this.mainMenu.run(this.scanner);
    }

    public void updateDefaults(){
        String defaultFarmName=AllMenus.farmAccount.getFarm().getFarmName();
        int farmIndex=farmList.indexOfName(defaultFarmName);
        farmList.setDefaultFarmIndex(farmIndex);

        int defaultAccountNumber=AllMenus.farmAccount.getBankAccount().getAccountNumber();
        int accountIndex= bankAccountList.indexOf(defaultAccountNumber);
        bankAccountList.setDefaultAccountIndex(accountIndex);
    }




}

