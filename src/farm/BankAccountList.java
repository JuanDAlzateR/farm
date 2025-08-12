package farm;

import abstracts.AbstractList;

import java.util.ArrayList;

public class BankAccountList {
    private ArrayList<BankAccount> bankAccounts= new ArrayList<>();
    int defaultAccountIndex =0;

    /* Looks in the array for the index of item with that name
        If it doesn't find it, it returns -1  */

    public int indexOf(int accountNumber) {
        for (int i = 0; i< bankAccounts.size(); i++){
            if (bankAccounts.get(i).getAccountNumber()==accountNumber){
                return i;
            }
        }
        return -1;
    }

    public void add(BankAccount bankAccount) {
        int index=indexOf(bankAccount.getAccountNumber());
        if (index>-1){
            System.out.println("Error: There is an account with the same account number");
        }else{
            bankAccounts.add(bankAccount);
        }
    }

    public void display() {
        for (int i=0; i<this.bankAccounts.size();i++) {
            int accountNumber=this.bankAccounts.get(i).getAccountNumber();
            String bankName=this.bankAccounts.get(i).getBankName();
            if(i==this.defaultAccountIndex){
                System.out.println(bankName+" - Account #: "+ accountNumber+" (Default Account)");
            }else{
                System.out.println(bankName+" - Account #: "+ accountNumber);
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
    public BankAccount setDefaultAccount(){
        return this.bankAccounts.get(this.defaultAccountIndex);
    }
}