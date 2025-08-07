package interfaces;

import abstracts.Account;

public interface Buy {

    default boolean buy(float price, Account account){
        if(account.getBalance()>=price){
            account.addBalance(-price);
            System.out.println("Transaction approved");
            System.out.println("Successfully bought an item for "+price);
            return true;
        }else{
            System.out.println("Transaction denied");
            System.out.println("Unsufficient founds, the account needs at least "+price);
            return false;
        }
    }

}
