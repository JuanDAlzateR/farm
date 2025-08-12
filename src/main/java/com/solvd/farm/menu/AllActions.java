package com.solvd.farm.menu;

import com.solvd.farm.animals.FarmAnimals;
import com.solvd.farm.farm.Farm;

import java.util.Scanner;

public class AllActions {
    //static Scanner scanner;

    // Methods for the menu actions
    public static Object[] newFarm(Object[] params) {
        System.out.println("Please type the name of the farm");
        String farmName = AllMenus.scanner.nextLine();
        Farm farm=new Farm(farmName);
        AllMenus.farmList.add(farm);
        return null;
    }

    public static Object[] displayFarms(Object[] params) {
        AllMenus.farmList.display();
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

    public static Object[] displayAnimals(Object[] params) {
        ((Farm)params[0]).displayAnimals();
        return null;
    }


}
