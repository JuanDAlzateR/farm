package crops;

import abstracts.Countable;
import interfaces.PassTime;

public class Crop extends Countable implements PassTime {

    private float germinationRate;
    private float growthPercentage;
    private float growthPerDay;

    public Crop() {
        super("new crop",0);
        this.germinationRate = 0.5F;
        this.growthPercentage = 0;
        this.growthPerDay = 1F;
    }

    public Crop(Grain grain) {
        super(grain.getName(),grain.getQuantity());
        this.germinationRate = 0.5F;
        this.growthPercentage = 0;
        this.growthPerDay = 1F;
        grain.setQuantity(0);
    }

    @Override
    public String toString(){
        return (this.getName() + " | expected quantity " + getExpectedQuantity()+ " | " + this.growthPercentage + "% of growth");
    }

    public void setGerminationRate(Float Rate) {
        this.germinationRate = Rate;
    }
    public void setGrowthPercentage(Float Percentage) {
        this.growthPercentage = Percentage;
    }
    public void setGrowthPerDay(Float growthPerDay) {
        this.growthPerDay = growthPerDay;
    }

    public float getGerminationRate() {
        return this.germinationRate;
    }
    public float getGrowthPercentage() {
        return this.growthPercentage;
    }
    public float getGrowthPerDay() {
        return this.growthPerDay;
    }
    public  int getExpectedQuantity() {
        return (int) (this.getQuantity()*this.germinationRate);
    }

    @Override
    public  void passTime(int days) {
        if(this.getQuantity()>0){
            float newGrowth = this.growthPercentage+this.growthPerDay*days;
            if (newGrowth >= 100) {
                newGrowth = 100;
            }
            this.growthPercentage=newGrowth;
        }
    }

}