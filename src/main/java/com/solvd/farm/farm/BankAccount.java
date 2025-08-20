package com.solvd.farm.farm;

import com.solvd.farm.abstracts.Account;
import com.solvd.farm.interfaces.IDisplay;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccount extends Account implements IDisplay {

    public static final Logger LOGGER = LogManager.getLogger(BankAccount.class);
    private String bankName;
    private int accountNumber;

    public BankAccount(String bankName, int accountNumber, Float balance, String accountNickname) {
        super(balance, accountNickname);
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    public BankAccount() {
        super();
        this.bankName = "New Bank";
        this.accountNumber = 0000;
    }

    public void display() {
        LOGGER.info("Account Nickname: " + this.getNickname());
        LOGGER.info("Bank:" + this.bankName + "   Account Number: " + this.accountNumber);
        LOGGER.info(String.format("Balance: %.2f " + this.getCurrency() + "%n", this.getBalance()));
        LOGGER.info("-------");
    }

    public void shortDisplay() {
        LOGGER.info(String.format("Account #: " + this.accountNumber + "  Balance: %.2f " + this.getCurrency() + "%n", this.getBalance()));
        LOGGER.info("-------");
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return this.bankName;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

}