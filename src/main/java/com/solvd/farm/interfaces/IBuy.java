package com.solvd.farm.interfaces;

import com.solvd.farm.farm.Farm;
import com.solvd.farm.abstracts.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IBuy {

    Logger LOGGER = LogManager.getLogger(IBuy.class);

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
                LOGGER.info("Transaction approved");
                LOGGER.info("Successfully bought " + item.getQuantity() + " " + item.getName() + " for total of " + price * quantity + " " + item.getCurrency());
                return true;
            } else {
                LOGGER.info("Transaction denied: Unsufficient founds.");
                LOGGER.info("The account needs at least " + price * quantity + " " + item.getCurrency() + " to buy " + item.getName());
                return false;
            }
        } else {
            LOGGER.info("Error in transaction: different currencies.");
            LOGGER.info("Account currency: " + account.getCurrency() + "!= Item currency: " + item.getCurrency());
            return false;
        }
    }

}
