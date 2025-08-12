package menu;

import farm.*;
import interfaces.IMenuAction;

import java.util.ArrayList;
import java.util.Scanner;

public class AllMenus {
    static Scanner scanner;
    static MenuAction mainMenu;
    static FarmList farmList=new FarmList();
    static BankAccountList bankAccountList=new BankAccountList();
    static FarmAccount farmAccount;

    public AllMenus() {
        farm.Farm farm = new farm.Farm();
        BankAccount bankAccount = new BankAccount("Bank", 1234, 2000F, "Income");
        FarmAccount account = new FarmAccount(farm,bankAccount);
        farmAccount=account;
        farmList.add(farm);
        bankAccountList.add(bankAccount);


        this.scanner = new Scanner(System.in);
        ArrayList<String> options = new ArrayList<>();
        ArrayList<IMenuAction> actions = new ArrayList<>();

        //First create all the menus, with the name
        MenuAction mainMenu = new MenuAction(scanner, "MAIN MENU");
        this.mainMenu=mainMenu;
        MenuAction chooseFarmMenu = new MenuAction(scanner, "CHOOSE FARM");
        MenuAction adminAccountsMenu = new MenuAction(scanner, "ADMIN BANK ACCOUNTS");
        MenuAction adminFarmMenu = new MenuAction(scanner, "ADMIN FARM");

        MenuAction adminAnimalsMenu = new MenuAction(scanner, "ADMIN FARM ANIMALS");

        //Now, define each menu, with the options and the actions

        //Main Menu
        actions.add(0, AllActions::exit);
        actions.add(1, chooseFarmMenu);
        actions.add(2, adminAccountsMenu);
        actions.add(3, adminFarmMenu);

        options.add(0, "Quit or Exit");
        options.add(1, "Create/Choose Farm");
        options.add(2, "Create/Choose Bank Account");
        options.add(3, "Admin Farm");

        mainMenu.setAndClear(options, actions);

        //Choose Farm Menu
        actions.add(0, mainMenu);
        actions.add(1, (params) -> AllActions.newFarm(params));
        actions.add(2, AllActions::editarAnimal);
        actions.add(3, AllActions::eliminarAnimal);
        actions.add(4, (params) -> AllActions.displayFarms(params));

        options.add(0, "Back to previous menu");
        options.add(1, "Create Farm");
        options.add(2, "Choose Default Farm");
        options.add(3, "Edit Farm");
        options.add(4, "Display all farms");

        chooseFarmMenu.setAndClear(options, actions);

        //Admin Accounts Menu
        actions.add(0, mainMenu);
        actions.add(1, (params) -> AllActions.addAnimal(params));
        actions.add(2, AllActions::editarAnimal);
        actions.add(3, AllActions::eliminarAnimal);

        options.add(0, "Back to previous menu");
        options.add(1, "Create Bank Account");
        options.add(2, "Choose Default Bank Account");
        options.add(3, "Edit Bank Account");

        adminAccountsMenu.setAndClear(options, actions);

        //Admin Farm Menu
        actions.add(0, mainMenu);
        actions.add(1, (params) -> AllActions.addAnimal(params));
        actions.add(2, AllActions::editarAnimal);
        actions.add(3, AllActions::eliminarAnimal);
        actions.add(4, AllActions::eliminarAnimal);

        options.add(0, "Back to previous menu");
        options.add(1, "Buy Items/Animals");
        options.add(2, "Admin Crops");
        options.add(3, "Admin Animals");
        options.add(4, "Sell Products");

        adminFarmMenu.setAndClear(options, actions);

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

