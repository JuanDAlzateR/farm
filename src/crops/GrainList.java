package crops;

import abstracts.AbstractList;

import java.util.ArrayList;

public class GrainList extends AbstractList {
    private ArrayList<Farm2> grains = new ArrayList<>();

    /* Looks in the array for the index of item with that name
        If it doesn't find it, it returns -1  */
    @Override
    public int indexOfName(String name) {
        for (int i=0; i< grains.size();i++){
            if (grains.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public void add(Farm2 grain) {
        int index=indexOfName(grain.getName());
        if (index>-1){
            grains.get(index).addQuantity(grain.getQuantity());
        }else{
            grains.add(grain);
        }
    }

    public void printAll() {
        for (Farm2 grain : grains) {
            System.out.println(grain);
        }
    }

    public ArrayList<Farm2> getList() {
        return this.grains;
    }

}