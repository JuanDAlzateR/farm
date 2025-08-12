package com.solvd.farm.menu;

import com.solvd.farm.animals.FarmAnimals;
import com.solvd.farm.farm.BankAccount;
import com.solvd.farm.farm.Farm;

public class AllActions {
    //static Scanner scanner;

    // Methods for the menu actions
    public static Object[] addFarm(Object[] params) {
        System.out.println("Please type the name of the farm");
        String farmName = AllMenus.scanner.nextLine();
        Farm farm=new Farm(farmName);
        AllMenus.farmList.add(farm);
        return null;
    }

    public static Object[] setDefaultFarm(Object[] params) {
        AllMenus.farmList.displayWithIndex();
        System.out.println("Please type the number of the farm to set as default");
        int index = AllMenus.scanner.nextInt();
        AllMenus.scanner.nextLine();
        AllMenus.farmList.setDefaultFarmIndex(index);
        Farm defaultFarm=AllMenus.farmList.getDefaultFarm();
        AllMenus.farmAccount.setFarm(defaultFarm);
        return null;
    }

    public static Object[] editFarm(Object[] params) {
        AllMenus.farmList.displayWithIndex();
        System.out.println("Please type the number of the farm to edit");
        int index = AllMenus.scanner.nextInt();
        AllMenus.scanner.nextLine();
        Farm farm =AllMenus.farmList.getList().get(index);
        System.out.println("Please type the new name of the farm");
        String farmName = AllMenus.scanner.nextLine();
        farm.setFarmName(farmName);
        return null;
    }

    public static Object[] displayFarms(Object[] params) {
        AllMenus.farmList.display();
        return null;
    }

    // Methods for the bank account menu
    public static Object[] addBankAccount(Object[] params) {
        System.out.println("Please type the name of the bank");
        String bankName = AllMenus.scanner.nextLine();
        System.out.println("Please type the account number");
        int accountNumber = AllMenus.scanner.nextInt();
        AllMenus.scanner.nextLine();
        System.out.println("Please type the account balance");
        float balance = AllMenus.scanner.nextFloat();
        AllMenus.scanner.nextLine();
        System.out.println("Please type the account nickname");
        String nickName = AllMenus.scanner.nextLine();

        BankAccount bankAccount=new BankAccount(bankName,accountNumber,balance,nickName);
        AllMenus.bankAccountList.add(bankAccount);
        return null;
    }

    public static Object[] setDefaultBankAccount(Object[] params) {
        AllMenus.bankAccountList.displayWithIndex();
        System.out.println("Please type the option number of the bank account to set as default");
        int index = AllMenus.scanner.nextInt();
        AllMenus.scanner.nextLine();
        AllMenus.bankAccountList.setDefaultAccountIndex(index);
        BankAccount defaultAccount=AllMenus.bankAccountList.getList().get(index);
        AllMenus.farmAccount.setBankAccount(defaultAccount);
        return null;
    }

    public static Object[] editBankAccount(Object[] params) {
        AllMenus.bankAccountList.displayWithIndex();
        System.out.println("Please type the option number of the bank account to edit");
        int index = AllMenus.scanner.nextInt();
        AllMenus.scanner.nextLine();
        BankAccount bankAccount=AllMenus.bankAccountList.getList().get(index);

        System.out.println("Current bank: "+bankAccount.getBankName()+". Please type the new name of the bank");
        String bankName = AllMenus.scanner.nextLine();
        System.out.println("Current Account number: "+bankAccount.getAccountNumber()+". Please type the account number");
        int accountNumber = AllMenus.scanner.nextInt();
        AllMenus.scanner.nextLine();
        System.out.println("Current balance: "+bankAccount.getBalance()+". Please type the account balance");
        float balance = AllMenus.scanner.nextFloat();
        AllMenus.scanner.nextLine();
        System.out.println("Current nickname: "+bankAccount.getNickname()+". Please type the account nickname");
        String nickName = AllMenus.scanner.nextLine();

        bankAccount.setBankName(bankName);
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setBalance(balance);
        bankAccount.setNickname(nickName);

        return null;
    }



    public static Object[] displayBankAccounts(Object[] params) {
        AllMenus.bankAccountList.display();
        return null;
    }

    public static Object[] addAnimal(Object[] params) {
        System.out.println("Adding animal...");
        if ((params[0] instanceof Farm)&&(params[1] instanceof FarmAnimals)){
            ((Farm) params[0]).addAnimal((FarmAnimals) params[1]);
        }
        // lógica aquí
        return null;
    }

    public static Object[] editarAnimal(Object[] params) {
        System.out.println("Editando animal...");
        // lógica aquí
        return null;
    }

    public static Object[] eliminarAnimal(Object[] params) {
        System.out.println("Eliminando animal...");
        // lógica aquí
        return null;
    }

    public static Object[] exit(Object[] params) {
        System.out.println("Closing...");
        System.exit(0);
        return null;
    }

    public static Object[] displayAnimals(Object[] params) {
        ((Farm)params[0]).displayAnimals();
        return null;
    }


}
