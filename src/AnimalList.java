import java.util.ArrayList;

public class AnimalList extends AbstractList {
    private ArrayList<Animal> animals = new ArrayList<>();

    /* Looks in the array for the index of item with that name
    If it doesn't find it, it returns -1  */
    @Override
    public int indexOfName(String name) {
        for (int i = 0; i< animals.size(); i++){
            if (animals.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public void add(Animal animal) {
        int index=indexOfName(animal.getName());
        if (index>-1){
            animals.get(index).addQuantity(animal.getQuantity());
        }else{
            animals.add(animal);
        }
    }

    public void printAll() {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public ArrayList<Animal> getList() {
        return this.animals;
    }

}