package com.solvd.farm.menu;

import com.solvd.farm.Main;
import com.solvd.farm.exceptions.InvalidOptionException;
import com.solvd.farm.interfaces.IMenuAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuAction implements IMenuAction {
    private String menuName = "New Menu";
    private Map<Integer, IMenuAction> actions = new HashMap<>();
    private ArrayList<String> options = new ArrayList<>();

    public MenuAction() {

    }

    public MenuAction(String menuName) {
        this.menuName = menuName;
    }

    public MenuAction(ArrayList<String> options, ArrayList<IMenuAction> actions) {
        this.options = options;
        for (int i = 0; i < actions.size(); i++) {
            this.actions.put(i, actions.get(i));
        }
    }

    public MenuAction(String menuName, ArrayList<String> options, ArrayList<IMenuAction> actions) {

        this.menuName = menuName;
        this.options = options;
        for (int i = 0; i < actions.size(); i++) {
            this.actions.put(i, actions.get(i));
        }
    }

    public String getMenuName() {
        return menuName;
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

    public void add(String option, IMenuAction action) {
        this.options.add(option);
        int lenght = actions.size();
        actions.put(lenght, action);
    }

    public Object[] run(Object... args) throws InvalidOptionException {
        int opcion;
        do {
            System.out.println(" ");
            displayMenu();

            opcion = AllActions.inputInt("Type an option: ");

            IMenuAction action = actions.get(opcion);

            if (action != null) {
                action.run(args);
            } else {
                Main.LOGGER.warn("Invalid input option in " + this.menuName + " menu");
                this.run(args);
                throw new InvalidOptionException();
                //System.out.println("Invalid option.");
            }
        } while (opcion != 0);
        return null;
    }

}
