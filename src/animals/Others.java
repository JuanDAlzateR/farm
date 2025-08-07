package animals;

//animals.Poultry → chickens, turkeys, ducks
public class Others extends FarmAnimals {
    public Others() {
        super("New animal",0, new AnimalFood(),new AnimalFeed());
    }

    public Others(String name, int quantity, AnimalFood animalFood, AnimalFeed animalFeed) {
        super(name, quantity, animalFood, animalFeed);
    }
}
