public abstract class AbstractIntQuantity extends AbstractNameable {

    private int quantity;

    public AbstractIntQuantity(){
        super();
        this.quantity=0;
    }

    public AbstractIntQuantity(String name, int quantity){
        super(name);
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

}