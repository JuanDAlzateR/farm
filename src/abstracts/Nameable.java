package abstracts;

public abstract class Nameable {

    private String name;

    public Nameable(){
        this.name="No Name";
    }

    public Nameable(String name){
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

}