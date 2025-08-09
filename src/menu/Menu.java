package menu;

import interfaces.Run;

import java.util.ArrayList;
import java.util.Scanner;
//change the name of the class for NodeMenu??
public class Menu implements Run {
    private ArrayList<MenuMethod> menuMethods = new ArrayList<>();
    private String menuName = "New Menu";

    public Menu(){

    }
    public Menu(String name){
        this.menuName=name;
    }

    public String getMenuName() {
        return menuName;
    }
    public ArrayList<MenuMethod> getMenuMethods() {
        return menuMethods;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public void setMenuMethods(ArrayList<MenuMethod> menuMethods) {
        this.menuMethods = menuMethods;
    }

    public void add(MenuMethod menuMethod){
        menuMethods.add(menuMethod);
    }

    @Override
    public void run(Object... args){
        System.out.println("=== "+ menuName + " ===");
        int index=0;
        for(MenuMethod menuMethod:menuMethods){
            System.out.println(index+") "+menuMethod.getOption());
            index++;
        }

        if (args.length==0){
            menuMethods.get(0).run();
        } else {
            if (args[0] instanceof Scanner){
                System.out.println("Type the number of the chosen option:");
                int option =((Scanner) args[0]).nextInt();
                System.out.println("------------");
                menuMethods.get(option).run(args);
            } else{
                System.out.println("Execution Error:");
                System.out.println("To choose an option, an scanner it's needed");
            }
        }
    }
}
