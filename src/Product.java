public class Product extends AbstractIntQuantity{

    private float rottenPercentage;
    private float rotPerDay;
    private float price;

    public Product() {
        super("New Product",0);
        this.rottenPercentage = 0;
        this.rotPerDay = 5F;
        this.price=1F;
    }

    public Product(Crop crop) {
        super(crop.getName(),crop.getExpectedQuantity());
        this.rottenPercentage = 0;
        this.rotPerDay = 2F;
        crop.setQuantity(0);
        this.price=1F;
    }

    @Override
    public String toString(){
        return (this.getName() + " | quantity " + getQuantity()+ " | " + this.rottenPercentage + "% of rot");
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    public void setRottenPercentage(Float Percentage) {
        this.rottenPercentage = Percentage;
    }
    public void setRotPerDay(Float rotPerDay) {
        this.rotPerDay = rotPerDay;
    }

    public float getPrice() {
        return this.price;
    }
    public float getRottenPercentage() {
        return this.rottenPercentage;
    }
    public float getRottenPerDay() {
        return this.rotPerDay;
    }

    public  void rot(int days) {
        if(this.getQuantity()>0){
            float newRot = this.rottenPercentage +this.rotPerDay *days;
            if (newRot >= 100) {
                newRot = 100;
            }
            this.rottenPercentage =newRot;
        }
    }

}