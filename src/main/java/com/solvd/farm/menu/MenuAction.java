package com.solvd.farm.menu;

import com.solvd.farm.exceptions.InvalidOptionException;
import com.solvd.farm.interfaces.IMenuAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuAction implements IMenuAction {

    public static final Logger LOGGER = LogManager.getLogger(MenuAction.class);
    private String menuName = "New Menu";
    private Map<Integer, IMenuAction> actions = new HashMap<>();
    private ArrayList<String> options = new ArrayList<>();

    public MenuAction() {

    }

    public MenuAction(String menuName) {
        this.menuName = menuName;
    }

//    public MenuAction(ArrayList<String> options, ArrayList<IMenuAction> actions) {
//        this.options = options;
//        for (int i = 0; i < actions.size(); i++) {
//            this.actions.put(i, actions.get(i));
//        }
//    }
//
//    public MenuAction(String menuName, ArrayList<String> options, ArrayList<IMenuAction> actions) {
//
//        this.menuName = menuName;
//        this.options = options;
//        for (int i = 0; i < actions.size(); i++) {
//            this.actions.put(i, actions.get(i));
//        }
//    }

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
        LOGGER.info("===== " + menuName + " =====");
        int i = 0;
        for (String option : this.options) {
            LOGGER.info(i + ") " + option);
            i++;
        }
    }

    public void add(String option, IMenuAction action) {
        this.options.add(option);
        int length = actions.size();
        actions.put(length, action);
    }

    public void run() throws InvalidOptionException {
        int option;
        do {
            LOGGER.info(" ");
            displayMenu();

            option = AllActions.inputInt("Type an option: ");

            IMenuAction action = actions.get(option);

            if (action != null) {
                action.run();
            } else {
                LOGGER.warn("Invalid input option in " + this.menuName + " menu");
                this.run();
                throw new InvalidOptionException();
            }
        } while (option != 0);
    }

}