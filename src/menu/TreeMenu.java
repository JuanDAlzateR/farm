package menu;

import java.util.ArrayList;

/*
This class will include all the menus to be implemented
 */
public class TreeMenu {
    private ArrayList<NodeMenu> allNodes = new ArrayList<>();
    private NodeMenu root;

    public TreeMenu(){

        this.root=mainMenu();
    }

    public ArrayList<NodeMenu> getAllNodes() {
        return allNodes;
    }
    public NodeMenu getMenu(int index) {
        return allNodes.get(index);
    }
    public NodeMenu getRoot() {
        return root;
    }

    public void display() {
        for (NodeMenu menu: allNodes){
            System.out.println(menu.getMenuName());
        }
    }

    public NodeMenu mainMenu(){
        NodeMenu mainMenu = new NodeMenu("MAIN MENU");
        allNodes.add(mainMenu);


        MenuMethod exitMethod = new MenuMethod("Quit or Exit",MenuMethod.exitMethod());
        NodeMenu exit = new NodeMenu("",exitMethod,mainMenu);

       // NodeMenu createFarm =createFarmMenu();
        NodeMenu adminBankAccounts =new NodeMenu("","Admin bank accounts");
        NodeMenu adminFarm =adminFarmMenu(mainMenu);

      //  mainMenu.add(createFarm);
        mainMenu.add(adminBankAccounts);
        mainMenu.add(adminFarm);
        mainMenu.add(exit);

        return mainMenu;
    }

    public NodeMenu adminFarmMenu(NodeMenu parentMenu){
        NodeMenu adminFarm = new NodeMenu("ADMIN FARM","Admin Farm");
        allNodes.add(adminFarm);

        NodeMenu buyItems =new NodeMenu("","Buy items or animals");
        NodeMenu adminCrops =new NodeMenu("","Admin Crops");
        NodeMenu sellProducts =new NodeMenu("","Sell products");
        MenuMethod goBackMethod =new MenuMethod("Go back to the previous menu",parentMenu);
        NodeMenu goBack =new NodeMenu("",goBackMethod,parentMenu);

        adminFarm.add(buyItems);
        adminFarm.add(adminCrops);
        adminFarm.add(sellProducts);
        adminFarm.add(goBack);

        return adminFarm;
    }



}

