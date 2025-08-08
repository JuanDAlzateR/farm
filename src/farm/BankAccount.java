package farm;

import abstracts.Account;
import interfaces.Display;

public class BankAccount extends Account implements Display {

    private String bankName;
    private int accountNumber;

    public BankAccount(String bankName, int accountNumber, Float balance, String accountNickname) {
        super(balance,accountNickname);
        this.bankName = bankName;
        this.accountNumber = accountNumber;
     }

    public BankAccount() {
        super();
        this.bankName ="New Bank";
        this.accountNumber=0000;
    }

    public void display() {
        System.out.println("Account Nickname: "+this.getNickname());
        System.out.println("Bank:"+ this.bankName + "   Account Number: "+this.accountNumber);
        System.out.printf("Balance: %.2f "+this.getCurrency()+"%n",this.getBalance());
        System.out.println("-------");
    }
    public void shortDisplay() {
        System.out.printf("Account #: "+this.accountNumber+"  Balance: %.2f "+this.getCurrency()+"%n",this.getBalance());
        System.out.println("-------");
    }

    public  void setBankName(String bankName) {
        this.bankName =bankName;
    }
    public  void setAccountNumber( int accountNumber) {
        this.accountNumber=accountNumber;
    }

    public  String getBankName( ) {
        return this.bankName ;
    }
    public  int getAccountNumber(  ) {
        return this.accountNumber;
    }

}