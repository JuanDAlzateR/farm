package abstracts;

public abstract class FloatPurchasable extends FloatCountable{

    private float price;
    private String currency;

    public FloatPurchasable(){
        super("New name",0);
        this.price=0;
        this.currency="usd";
    }
    public FloatPurchasable(String name){
        super(name,1);
        this.price=0;
        this.currency="usd";
    }
        public FloatPurchasable(String name, float quantity){
        super(name,quantity);
        this.price=0;
        this.currency="usd";
    }
    public FloatPurchasable(String name, float quantity, float price){
        super(name,quantity);
        this.price=price;
        this.currency="usd";
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getPrice() {
        return this.price;
    }
    public String getCurrency() {
        return this.currency;
    }
}