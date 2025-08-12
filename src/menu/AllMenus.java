package menu;

import interfaces.IMenuAction;

import java.util.ArrayList;
import java.util.Scanner;

public class AllMenus {
    private Scanner scanner;
    private MenuAction mainMenu;

    public AllMenus() {
        this.scanner = new Scanner(System.in);
        ArrayList<String> options = new ArrayList<>();
        ArrayList<IMenuAction> actions = new ArrayList<>();

        //First create all the menus, with the name
        MenuAction mainMenu = new MenuAction(scanner, "MAIN MENU");
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

        mainMenu.setMenu(options, actions);
        options.clear();
        actions.clear();

        //Admin Farm Menu
        actions.add(0, mainMenu);
        actions.add(1, (params) -> AllActions.addAnimal(params));
        actions.add(2, AllActions::editarAnimal);
        actions.add(3, AllActions::eliminarAnimal);

        options.add(0, "Back to previous menu");
        options.add(1, "Create/Choose Farm");
        options.add(2, "Create/Choose Bank Account");
        options.add(3, "Admin Farm");

        adminFarmMenu.setMenu(options, actions);
        options.clear();
        actions.clear();

        this.mainMenu=mainMenu;
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



}

