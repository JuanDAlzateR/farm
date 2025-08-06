public abstract class AbstractNameable {

    private String name;

    public AbstractNameable(){
        this.name="No Name";
    }

    public AbstractNameable(String name){
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

}