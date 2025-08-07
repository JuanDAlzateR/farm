package interfaces;

import abstracts.Account;

public interface Buy {

    static boolean buy(Buy item, Account account){
        float price=item.getPrice();
        float quantity=item.getQuantity();

        if (item.getCurrency().equals(account.getCurrency())){
            if(account.getBalance()>=price*quantity){
                account.addBalance(-price*quantity);
                System.out.println("Transaction approved");
                System.out.println("Successfully bought " + item.getName()+" for total of "+ price*quantity +" "+item.getCurrency());
                return true;
            }else{
                System.out.println("Transaction denied: Unsufficient founds.");
                System.out.println("The account needs at least "+price*quantity+" "+item.getCurrency()+" to buy "+item.getName());
                return false;
            }
        } else{
            System.out.println("Error in transaction: different currencies.");
            System.out.println("Account currency: "+account.getCurrency()+"!= Item currency: "+item.getCurrency());
            return false;
        }
    }

    float getPrice();
    String getName();
    String getCurrency();
    float getQuantity();
}
