import abstracts.Account;
import abstracts.Countable;
import crops.Crop;
import interfaces.Buy;
import interfaces.PassTime;

public class Tool implements PassTime, Buy {

    private float wearAndTearPercentage;
    private float wearAndTearPerDay;
    private float price;
    private String name;

    public Tool() {
        this.name="New Tool";
        this.wearAndTearPercentage = 0;
        this.wearAndTearPerDay = 0.1F;
        this.price=100F;
    }

    public Tool(String name, float price) {
        this.name=name;
        this.wearAndTearPercentage = 0;
        this.wearAndTearPerDay = 0.1F;
        this.price=price;
    }

    @Override
    public String toString(){
        return (this.getName() + " | " + this.wearAndTearPercentage + "% of wear and tear");
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    public void setRottenPercentage(Float Percentage) {
        this.wearAndTearPercentage = Percentage;
    }
    public void setWearAndTearPerDay(Float wearAndTearPerDay) {
        this.wearAndTearPerDay = wearAndTearPerDay;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }
    public float getRottenPercentage() {
        return this.wearAndTearPercentage;
    }
    public float getRottenPerDay() {
        return this.wearAndTearPerDay;
    }
    public String getName() {
        return this.name;
    }

    @Override
    public void passTime(int days) {
        float newPercentage = this.wearAndTearPercentage +this.wearAndTearPerDay *days;
        if (newPercentage >= 100) {
            newPercentage = 100;
        }
        this.wearAndTearPercentage =newPercentage;
    }

}