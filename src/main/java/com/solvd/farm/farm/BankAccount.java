package com.solvd.farm.farm;

import com.solvd.farm.abstracts.Account;
import com.solvd.farm.display.DisplayMethod;
import com.solvd.farm.display.DisplayType;
import com.solvd.farm.display.Displayable;
import com.solvd.farm.interfaces.IDisplay;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Displayable
public class BankAccount extends Account implements IDisplay {

    public static final Logger LOGGER = LogManager.getLogger(BankAccount.class);
    private final AccountRecord accountRecord;


    public BankAccount(String bankName, int accountNumber, Float balance, String accountNickname) {
        super(balance, accountNickname);
        accountRecord = new AccountRecord(bankName, accountNumber);
    }

    @DisplayMethod
    public void display() {
        LOGGER.info("Account Nickname: " + this.getNickname());
        LOGGER.info("Bank:" + accountRecord.bankName() + "   Account Number: " + accountRecord.accountNumber());
        LOGGER.info(String.format("Balance: %.2f " + this.getCurrency() + "%n", this.getBalance()));
        LOGGER.info("-------");
    }

    @DisplayMethod(displayType = DisplayType.SHORT)
    public void shortDisplay() {
        LOGGER.info(String.format("Account #: " + accountRecord.accountNumber() + "  Balance: %.2f " + this.getCurrency() + "%n", this.getBalance()));
        LOGGER.info("-------");
    }

    public String getBankName() {
        return accountRecord.bankName();
    }

    public int getAccountNumber() {
        return accountRecord.accountNumber();
    }

}