package com.solvd.farm.farm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class BankAccountList {

    public static final Logger LOGGER = LogManager.getLogger(BankAccountList.class);
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    int defaultAccountIndex = 0;

    /* Looks in the array for the index of item with that name
        If it doesn't find it, it returns -1  */

    public int indexOf(int accountNumber) {
        for (int i = 0; i < bankAccounts.size(); i++) {
            if (bankAccounts.get(i).getAccountNumber() == accountNumber) {
                return i;
            }
        }
        return -1;
    }

    public void add(BankAccount bankAccount) {
        int index = indexOf(bankAccount.getAccountNumber());
        if (index > -1) {
            LOGGER.info("Error: There is an account with the same account number");
        } else {
            bankAccounts.add(bankAccount);
        }
    }

    public void display(Boolean displayIndex) {
        LOGGER.info("");
        LOGGER.info("list of all bank accounts");
        String indexString="";
        for (int i = 0; i < this.bankAccounts.size(); i++) {
            int accountNumber = this.bankAccounts.get(i).getAccountNumber();
            String bankName = this.bankAccounts.get(i).getBankName();
            if (displayIndex){indexString=i+") ";}
            if (i == this.defaultAccountIndex) {
                LOGGER.info("\t" + indexString + bankName + " - Account #: " + accountNumber + " (Default Account)");
            } else {
                LOGGER.info("\t" + indexString + bankName + " - Account #: " + accountNumber);
            }
        }
    }

    public void displayWithBalance() {
        LOGGER.info("");
        LOGGER.info("list of all bank accounts");
        for (int i = 0; i < this.bankAccounts.size(); i++) {
            int accountNumber = this.bankAccounts.get(i).getAccountNumber();
            String bankName = this.bankAccounts.get(i).getBankName();
            float balance= this.bankAccounts.get(i).getBalance();
            if (i == this.defaultAccountIndex) {
                LOGGER.info("\t" + i + ") " + bankName + " - Account #: " + accountNumber +
                        "- Balance: "+ balance + " (Default Account)");
            } else {
                LOGGER.info("\t" + i + ") " + bankName + " - Account #: " + accountNumber +
                        "- Balance: "+ balance);
            }
        }
    }

    public ArrayList<BankAccount> getList() {
        return this.bankAccounts;
    }
    public void setDefaultAccountIndex(int defaultAccountIndex) {
        this.defaultAccountIndex = defaultAccountIndex;
    }

    public int getDefaultAccountIndex() {
        return defaultAccountIndex;
    }
    public BankAccount setDefaultAccount() {
        return this.bankAccounts.get(this.defaultAccountIndex);
    }
}