import abstracts.Purchasable;
import crops.Crop;
import interfaces.PassTime;
import interfaces.Buy;

public class Product extends Purchasable implements PassTime, Buy {

    private float rottenPercentage;
    private float rotPerDay;

    public Product() {
        super("New Product",0);
        this.rottenPercentage = 0;
        this.rotPerDay = 5F;
    }

    public Product(Crop crop) {
        super(crop.getName(),crop.getExpectedQuantity());
        this.rottenPercentage = 0;
        this.rotPerDay = 2F;
        crop.setQuantity(0);
    }

    @Override
    public String toString(){
        return (this.getName() + " | quantity " + getQuantity()+ " | " + this.rottenPercentage + "% of rot");
    }

    public void setRottenPercentage(Float Percentage) {
        this.rottenPercentage = Percentage;
    }
    public void setRotPerDay(Float rotPerDay) {
        this.rotPerDay = rotPerDay;
    }

    public float getRottenPercentage() {
        return this.rottenPercentage;
    }
    public float getRottenPerDay() {
        return this.rotPerDay;
    }

    @Override
    public  void passTime(int days) {
        if(this.getQuantity()>0){
            float newRot = this.rottenPercentage +this.rotPerDay *days;
            if (newRot >= 100) {
                newRot = 100;
            }
            this.rottenPercentage =newRot;
        }
    }

}