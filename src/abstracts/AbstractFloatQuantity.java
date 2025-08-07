package abstracts;

public abstract class AbstractFloatQuantity extends Nameable {

    private float quantity;

    public AbstractFloatQuantity(){
        super();
        this.quantity=0F;
    }

    public AbstractFloatQuantity(String name, float quantity){
        super(name);
        this.quantity=quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
    public void addQuantity(float quantity) {
        this.quantity += quantity;
    }
    public float getQuantity() {
        return this.quantity;
    }

}