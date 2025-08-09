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

        NodeMenu createFarm =createFarmMenu(mainMenu);
        NodeMenu adminBankAccounts =new NodeMenu("","Admin bank accounts");
        NodeMenu adminFarm =adminFarmMenu(mainMenu);
        NodeMenu exit=createExit(mainMenu);

        mainMenu.add(createFarm);
        mainMenu.add(adminBankAccounts);
        mainMenu.add(adminFarm);
        mainMenu.add(exit);

        return mainMenu;
    }

    public NodeMenu mainMenu2(){
        NodeMenu mainMenu = new NodeMenu("MAIN MENU");
        allNodes.add(mainMenu);

        mainMenu.add(createFarmMenu(mainMenu));
        mainMenu.add(new NodeMenu("","Admin bank accounts"));
        mainMenu.add(adminFarmMenu(mainMenu));
        mainMenu.add(createExit(mainMenu));

        return mainMenu;
    }

    public NodeMenu createExit(NodeMenu parentMenu){
        MenuMethod exitMethod = new MenuMethod("Quit or Exit",MenuMethod.exitMethod());
        NodeMenu exit = new NodeMenu("",exitMethod,parentMenu);
        return exit;
    }
    public NodeMenu createGoBack(NodeMenu parentMenu){
        MenuMethod goBackMethod =new MenuMethod("Go back to the previous menu",parentMenu);
        NodeMenu goBack =new NodeMenu("",goBackMethod,parentMenu);
        return goBack;
    }

    public NodeMenu createFarmMenu(NodeMenu parentMenu){
        NodeMenu createFarm = new NodeMenu("LIST OF FARMS","Create/Choose farm");
        allNodes.add(createFarm);

        NodeMenu newFarm =new NodeMenu("","Create a farm");
        NodeMenu editFarm =new NodeMenu("","Edit a farm");
        NodeMenu chooseFarm =new NodeMenu("","Choose the active farm");
        NodeMenu goBack =createGoBack(parentMenu);

        createFarm.add(newFarm);
        createFarm.add(editFarm);
        createFarm.add(chooseFarm);
        createFarm.add(goBack);

        return createFarm;
    }

    public NodeMenu adminFarmMenu(NodeMenu parentMenu){
        NodeMenu adminFarm = new NodeMenu("ADMIN FARM","Admin Farm");
        allNodes.add(adminFarm);

        NodeMenu buyItems =new NodeMenu("","Buy items or animals");
        NodeMenu adminCrops =new NodeMenu("","Admin Crops");
        NodeMenu sellProducts =new NodeMenu("","Sell products");
        NodeMenu goBack =createGoBack(parentMenu);

        adminFarm.add(buyItems);
        adminFarm.add(adminCrops);
        adminFarm.add(sellProducts);
        adminFarm.add(goBack);

        return adminFarm;
    }


}

