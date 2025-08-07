package crops;

import abstracts.Countable;

public class Grain extends Countable {

    public Grain(String name, int quantity) {
        super(name,quantity);
    }

    public Grain() {
        super("New grain",0);
    }

    @Override
    public String toString(){
        return (this.getQuantity()+ " seeds of "+this.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Grain)) {
            return false;
        } else if (((Grain) o).getName().equals(this.getName())) {
            return true;
        } else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return this.getName().hashCode();
    }

    public  void sow( int quantity) {
        if (quantity<=this.getQuantity() && quantity>=0) {
            this.addQuantity(-quantity);
        }else if (quantity>=0){
            this.setQuantity(0);
            System.out.println("All seeds sown. Quantity of "+this.getName()+" set to 0.");
        }else{
            System.out.println("Error, you can't sow a negative amount");
        }
    }

}