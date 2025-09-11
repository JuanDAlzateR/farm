package com.solvd.farm.farm;

import com.solvd.farm.display.Display;
import com.solvd.farm.display.DisplayType;
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

    public void display() {
        LOGGER.info("BANK ACCOUNT:");
        Display.display(account);
        LOGGER.info("FARM INFO:");
        Display.display(farm);
        LOGGER.info("-------");
    }

    public void buyItem(IBuy item) {
        LOGGER.info(farm.getDate());
        if (IBuy.buy(item, this.account)) {
            item.addToFarm(this.farm);
            Display.display(account, DisplayType.SHORT);
        }
    }

}