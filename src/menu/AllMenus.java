package menu;

import java.util.ArrayList;

/*
This class will include all the menus to be implemented
 */
public class AllMenus {
    private ArrayList<Menu> allMenus= new ArrayList<>();

    public AllMenus(){
//        ArrayList<Menu> menus = new ArrayList<>();
//        menus.add(mainMenu());
//        this.allMenus=menus;
        mainMenu();
    }

    public ArrayList<Menu> getAllMenus() {
        return allMenus;
    }
    public Menu getMenu(int index) {
        return allMenus.get(index);
    }
    public void display() {
        for (Menu menu:allMenus){
            System.out.println(menu.getMenuName());
        }
    }

    public Menu mainMenu(){
        Menu mainMenu = new Menu("MAIN MENU");
        allMenus.add(mainMenu);
        ExitMethod exitMethod = MenuMethod.exitMethod();

        MenuMethod createFarm =new MenuMethod("Create/Choose Farm",createFarmMenu(mainMenu));
        MenuMethod adminBankAccounts =new MenuMethod("Admin bank accounts");
        MenuMethod adminFarm =new MenuMethod("Admin Farm",adminFarmMenu(mainMenu));
        MenuMethod exit =new MenuMethod("Quit or Exit",exitMethod);

        mainMenu.add(createFarm);
        mainMenu.add(adminBankAccounts);
        mainMenu.add(adminFarm);
        mainMenu.add(exit);

        return mainMenu;
    }

    public Menu adminFarmMenu(Menu previousMenu){
        Menu adminFarm = new Menu("ADMIN FARM");
        allMenus.add(adminFarm);

        MenuMethod buyItems =new MenuMethod("Buy items or animals");
        MenuMethod adminCrops =new MenuMethod("Admin Crops");
        MenuMethod sellProducts =new MenuMethod("Sell products");
        MenuMethod goBack =new MenuMethod("Go back to the previous menu",previousMenu);


        adminFarm.add(buyItems);
        adminFarm.add(adminCrops);
        adminFarm.add(sellProducts);
        adminFarm.add(goBack);


        return adminFarm;
    }

    public Menu createFarmMenu(Menu previousMenu){
        Menu createFarm = new Menu("LIST OF FARMS");
        allMenus.add(createFarm);

        MenuMethod newFarm =new MenuMethod("Create a farm");
        MenuMethod editFarm =new MenuMethod("Edit a farm");
        MenuMethod chooseFarm =new MenuMethod("Choose the active farm");
        MenuMethod goBack =new MenuMethod("Go back to the previous menu",previousMenu);


        createFarm.add(newFarm);
        createFarm.add(editFarm);
        createFarm.add(chooseFarm);
        createFarm.add(goBack);


        return createFarm;
    }

}

