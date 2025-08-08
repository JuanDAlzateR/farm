package menu;

public class NodeMenu extends Menu{
    private NodeMenu parent=null;
    private int height=0;

    public NodeMenu(String name){
        super(name);
    }
    public NodeMenu(NodeMenu parent){
        this.parent=parent;
        this.height=parent.getHeight()+1;
    }
    public NodeMenu(String name, NodeMenu parent){
        super(name);
        this.parent=parent;
        this.height=parent.getHeight()+1;
    }

    public NodeMenu getParent() {
        return this.parent;
    }
    public int getHeight() {
        return this.height;
    }
    public void setParent(NodeMenu parent) {
        this.parent = parent;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
