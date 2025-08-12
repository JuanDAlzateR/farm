package com.solvd.farm.menu;

import com.solvd.farm.interfaces.IMenuAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuAction implements IMenuAction {
    private String menuName = "New Menu";
    private Map<Integer, IMenuAction> actions = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String> options = new ArrayList<>();

    public MenuAction() {

    }

    public MenuAction(Scanner scanner, String menuName) {
        this.scanner=scanner;
        this.menuName=menuName;
    }

    public MenuAction(ArrayList<String> options, ArrayList<IMenuAction> actions) {
        this.options = options;
        for (int i = 0; i < actions.size(); i++) {
            this.actions.put(i, actions.get(i));
        }
    }

    public MenuAction(Scanner scanner, String menuName, ArrayList<String> options, ArrayList<IMenuAction> actions) {
        this.scanner=scanner;
        this.menuName=menuName;
        this.options = options;
        for (int i = 0; i < actions.size(); i++) {
            this.actions.put(i, actions.get(i));
        }
    }

    public String getMenuName() {
        return menuName;
    }
    public Scanner getScanner() {
        return scanner;
    }
    public ArrayList<String> getOptions() {
        return options;
    }
    public Map<Integer, IMenuAction> getActions() {
        return actions;
    }

    public void setAndClear(ArrayList<String> options, ArrayList<IMenuAction> actions) {
        this.options = new ArrayList<>(options);
        for (int i = 0; i < actions.size(); i++) {
            this.actions.put(i, actions.get(i));
        }
        options.clear();
        actions.clear();
    }

    public void displayMenu() {
        System.out.println("===== " + menuName + " =====");
        int i = 0;
        for (String option : this.options) {
            System.out.println(i + ") " + option);
            i++;
        }
    }

    public Object[] run(Object... args) {
        int opcion;
        do {
            System.out.println(" ");
            displayMenu();
            System.out.print("Type an option: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            IMenuAction action = actions.get(opcion);
            if (action != null) {
                action.run(args);
            } else {
                System.out.println("Invalid option.");
            }
        } while (opcion != 0);
        return null;
    }

}
