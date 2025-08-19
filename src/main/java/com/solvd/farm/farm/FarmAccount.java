package com.solvd.farm.farm;

import com.solvd.farm.Main;
import com.solvd.farm.interfaces.IBuy;
import com.solvd.farm.interfaces.IDisplay;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FarmAccount implements IDisplay {

    public static final Logger LOGGER = LogManager.getLogger(FarmAccount.class);
    private BankAccount account;
    private Farm farm;

    public FarmAccount(Farm farm, BankAccount account) {
        this.account = account;
        this.farm = farm;
    }

    public void display() {
        LOGGER.info("BANK ACCOUNT:");
        account.display();
        LOGGER.info("FARM INFO:");
        farm.display();
        LOGGER.info("-------");
    }

    public void setBankAccount(BankAccount account) {
        this.account = account;
    }
    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public BankAccount getBankAccount() {
        return this.account;
    }
    public Farm getFarm() {
        return this.farm;
    }

    public void buyItem(IBuy item) {
        LOGGER.info(farm.getDate());
        if (IBuy.buy(item, this.account)) {
            item.addToFarm(this.farm);
            account.shortDisplay();
        }
    }

}