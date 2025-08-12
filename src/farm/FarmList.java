package farm;

import abstracts.AbstractList;


import java.util.ArrayList;

public class FarmList extends AbstractList {
    private ArrayList<farm.Farm> farms = new ArrayList<>();
    int defaultFarmIndex=0;

    /* Looks in the array for the index of item with that name
        If it doesn't find it, it returns -1  */
    @Override
    public int indexOfName(String name) {
        for (int i = 0; i< farms.size(); i++){
            if (farms.get(i).getFarmName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public void add(Farm farm) {
        int index=indexOfName(farm.getFarmName());
        if (index>-1){
            System.out.println("Error: There is a farm with that name already");
        }else{
            farms.add(farm);
        }
    }

    public void display() {
        for (int i=0; i<this.farms.size();i++) {
            if(i==this.defaultFarmIndex){
                System.out.println(this.farms.get(i).getFarmName()+ "(Default)");
            }else{
                System.out.println(this.farms.get(i).getFarmName());
            }
        }
    }

    public ArrayList<Farm> getList() {
        return this.farms;
    }

    public void setDefaultFarmIndex(int defaultFarmIndex) {
        this.defaultFarmIndex = defaultFarmIndex;
    }

    public int getDefaultFarmIndex() {
        return defaultFarmIndex;
    }
    public Farm getDefaultFarm(){
        return this.farms.get(this.defaultFarmIndex);
    }
}