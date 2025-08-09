package menu;

import interfaces.Run;

import java.util.ArrayList;
import java.util.Scanner;
//change the name of the class for NodeMenu??
public class NodeMenu implements Run {
    private ArrayList<NodeMenu> nodeMenus = new ArrayList<>();
    private String menuName = "New Menu";
    private MenuMethod menuMethod = new MenuMethod();
    private NodeMenu parent=null;

    private int height=0;

    public NodeMenu(){

    }
    public NodeMenu(String name){
        this.menuName=name;
    }
    public NodeMenu(String name, String option){
        this.menuName=name;
        this.menuMethod=new MenuMethod(option);

    }

    public NodeMenu(NodeMenu parent){
        this.parent=parent;
        this.height=parent.getHeight()+1;
    }

    public NodeMenu(String name,String option, NodeMenu parent){
        this.menuName=name;
        this.parent=parent;
        this.height=parent.getHeight()+1;
    }
    public NodeMenu(String name,MenuMethod menuMethod,NodeMenu parent){
        this.menuName=name;
        this.menuMethod=menuMethod;
        this.parent=parent;
        this.height=parent.getHeight()+1;
    }


    public NodeMenu getParent() {
        return this.parent;
    }
    public int getHeight() {
        return this.height;
    }
    public String getMenuName() {
        return menuName;
    }
    public ArrayList<NodeMenu> getMenuMethods() {
        return nodeMenus;
    }
    public MenuMethod getMenuMethod() {
        return menuMethod;
    }


    public void setParent(NodeMenu parent) {
        this.parent = parent;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public void setNodeMenus(ArrayList<NodeMenu> nodeMenus) {
        this.nodeMenus = nodeMenus;
    }
    public void setMenuMethod(MenuMethod menuMethod) {
        this.menuMethod = menuMethod;
    }


    public void add(NodeMenu nodeMenu){
        nodeMenus.add(nodeMenu);
        nodeMenu.setParent(this);
        nodeMenu.setHeight(this.height+1);
    }

    public boolean isLeaf(){
        return nodeMenus.isEmpty();
    }



    public void display(String indent){
        String indent1=indent;
        if(parent==null){
            indent1="";
        }else{
            System.out.println(parent.menuName);
        }
        System.out.println(indent1+menuName+" ("+menuMethod.getOption()+")");
        for(NodeMenu nodeMenu: nodeMenus){
            System.out.println(indent1+indent+nodeMenu.getMenuMethod().getOption());
        }
    }

    @Override
    public void run(Object... args){
        if (this.isLeaf()){
            System.out.println("running method...");
            this.menuMethod.run(args);
        }
        else{
            System.out.println("=== "+ menuName + " ===");
            int index=0;
            for(NodeMenu nodeMenu: nodeMenus){
                System.out.println(index+") "+nodeMenu.getMenuMethod().getOption());
                index++;
            }

            if (args.length==0){
                nodeMenus.get(0).run(); //Maybe it needs to be changed later
            } else {
                if (args[0] instanceof Scanner){
                    System.out.println("Type the number of the chosen option:");
                    int option =((Scanner) args[0]).nextInt();
                    System.out.println("------------");
                    nodeMenus.get(option).run(args);
                } else{
                    System.out.println("Execution Error:");
                    System.out.println("To choose an option, an scanner it's needed");
                }
            }
        }

    }
}