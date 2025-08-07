package abstracts;

public abstract class Account {

    private String accountNickname;
    private Float balance;
    private String currency;

    public Account(Float balance, String accountNickname) {
        this.balance = balance;
        this.accountNickname = accountNickname;
        this.currency = "usd";
    }

    public Account() {
        this.balance=0F;
        this.accountNickname="New Account";
        this.currency="usd";
    }

    public  void setNickname(String name) {
        this.accountNickname=name;
    }
    public  void setBalance( Float balance) {
        this.balance=balance;
    }
    public  void setCurrency(String currency) {
        this.currency =currency;
    }
    public  void addBalance( Float balance) {
        this.balance+=balance;
    }

    public  String getNickname( ) {
        return this.accountNickname;
    }
    public  Float getBalance(  ) {
        return this.balance;
    }
    public  String getCurrency( ) {
        return this.currency ;
    }

}