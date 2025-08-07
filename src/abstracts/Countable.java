package abstracts;

public abstract class Countable {

    private int quantity;
    private String name;

    public Countable(){
        this.name="New name";
        this.quantity=0;
    }

    public Countable(String name, int quantity){
        this.name=name;
        this.quantity=quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
    public int getQuantity() {
        return this.quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

}