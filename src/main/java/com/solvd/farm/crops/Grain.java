package com.solvd.farm.crops;

import com.solvd.farm.interfaces.IBuy;
import com.solvd.farm.abstracts.Purchasable;
import com.solvd.farm.farm.Farm;

public class Grain extends Purchasable implements IBuy {

    public Grain(String name, float quantity) {
        super(name,quantity);
    }
    public Grain(String name, float quantity, float price){
        super(name,quantity,price);

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

    @Override
    public void addToFarm(Farm farm){
        farm.addGrain(this);
    }
}