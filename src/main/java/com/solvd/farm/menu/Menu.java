package com.solvd.farm.menu;


import com.solvd.farm.farm.Farm;
import com.solvd.farm.interfaces.ReturnRun;
import com.solvd.farm.interfaces.Run;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static NodeMenu createMenu(){

        ArrayList<String> options =new ArrayList<>();
        options.add("Create/Choose farm");
        options.add("Admin bank accounts");
        options.add("Admin Farm");
        options.add("Quit or Exit");
        NodeMenu mainMenu =new NodeMenu("main menu","MAIN MENU",options);
        createExit(3,mainMenu);

        options.clear();
        options.add("Create a new farm");
        options.add("Edit a farm");
        options.add("Choose active farm");
        options.add("Go back to the previous menu");
        NodeMenu createFarm=mainMenu.getNode(0);
        createFarm.add(options);
        createGoBack(3,createFarm,mainMenu);
        newFarm(0,createFarm);



        return mainMenu;
    }

    public static void createExit(int index,NodeMenu parentMenu){
        MenuMethod exitMethod = new MenuMethod("Quit or Exit",MenuMethod.exitMethod());
        NodeMenu exit = new NodeMenu("",exitMethod,parentMenu);
        parentMenu.setChildNode(index,exit);
    }

    public static void createGoBack(int index,NodeMenu parentMenu,NodeMenu grandParentMenu){
        MenuMethod goBackMethod =new MenuMethod("Go back to the previous menu",grandParentMenu);
        NodeMenu goBack =new NodeMenu("",goBackMethod,grandParentMenu);
        parentMenu.setChildNode(index,goBack);
    }

    public static void newFarm(int index,NodeMenu parentMenu){
        Farm farm=new Farm();
        newFarmMethod createFarm =new newFarmMethod(farm,parentMenu);
        MenuMethod newfarm=new MenuMethod("Create new farm",createFarm);
        parentMenu.setChildMethod(index,newfarm);

    }


}

class GenericMethod implements ReturnRun {
    String message;
    public GenericMethod(String message){
        this.message=message;
    }
    @Override
    public Object[] run(Object... args){

        if (args.length==0){
            //nodeMenus.get(0).run(); //Maybe it needs to be changed later
        } else {
            if (args[0] instanceof Scanner){
                System.out.println(message);
                String option =((Scanner) args[0]).nextLine();
                System.out.println("------------");


            } else{
                System.out.println("Execution Error:");
                System.out.println("To choose an option, an scanner it's needed");
            }
        }

    return null;
    }
}

class newFarmMethod implements Run {
    String message="Please enter a name for the farm";
    Farm farm;
    NodeMenu parentMenu;
    public newFarmMethod(Farm farm,NodeMenu parentMenu){
        this.farm=farm;
        this.parentMenu=parentMenu;
    }
    @Override
    public Object[] run(Object... args){

        if (args.length==0){
            //nodeMenus.get(0).run(); //Maybe it needs to be changed later
        } else {
            if (args[0] instanceof Scanner){
                System.out.println(message);
                String option =((Scanner) args[0]).next();
                this.farm.setFarmName(option);
                System.out.println("correct name assign");
                System.out.println("------------");

            }else{
                System.out.println("Execution Error:");
                System.out.println("To choose an option, an scanner it's needed");
            }
        }
        this.parentMenu.run(args);
        Object[] outObject;

        //return this.farm;
        return null;
    }
}
