package farm;

import interfaces.Buy;
import interfaces.Display;

public class FarmAccount implements Display {

    private BankAccount account;
    private Farm farm;

    public FarmAccount(Farm farm,BankAccount account) {
        this.account = account;
        this.farm = farm;
     }

    public void display() {
        System.out.println("BANK ACCOUNT:");
        account.display();
        System.out.println("FARM INFO:");
        farm.display();
        System.out.println("-------");
    }

    public  void setBankAccount(BankAccount account) {
        this.account =account;
    }
    public  void setFarm( Farm farm) {
        this.farm=farm;
    }

    public  BankAccount getBankAccount( ) {
        return this.account ;
    }
    public  Farm getFarm(  ) {
        return this.farm;
    }
    public void buyItem(Buy item){
        System.out.println(farm.getDate());
        if (Buy.buy(item,this.account)){
            item.addToFarm(this.farm);
            account.shortDisplay();
        }
    }

}