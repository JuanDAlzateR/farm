package com.solvd.farm.interfaces;

import com.solvd.farm.farm.Farm;
import com.solvd.farm.abstracts.Account;

public interface IBuy {

    float getPrice();
    String getName();
    String getCurrency();
    float getQuantity();

    void setPrice(float price);
    void setName(String name);
    void setCurrency(String currency);
    void setQuantity(float quantity);

    void addToFarm(Farm farm);

    static boolean buy(IBuy item, Account account) {
        float price = item.getPrice();
        float quantity = item.getQuantity();

        if (item.getCurrency().equals(account.getCurrency())) {
            if (account.getBalance() >= price * quantity) {
                account.addBalance(-price * quantity);
                System.out.println("Transaction approved");
                System.out.println("Successfully bought " + item.getQuantity() + " " + item.getName() + " for total of " + price * quantity + " " + item.getCurrency());
                return true;
            } else {
                System.out.println("Transaction denied: Unsufficient founds.");
                System.out.println("The account needs at least " + price * quantity + " " + item.getCurrency() + " to buy " + item.getName());
                return false;
            }
        } else {
            System.out.println("Error in transaction: different currencies.");
            System.out.println("Account currency: " + account.getCurrency() + "!= Item currency: " + item.getCurrency());
            return false;
        }
    }

}
