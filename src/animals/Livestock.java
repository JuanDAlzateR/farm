package animals;

//animals.Poultry → chickens, turkeys, ducks
public class Livestock extends FarmAnimals {
    public Livestock() {
        super("New animal",0, new AnimalFood(),new AnimalFeed());
    }

    public Livestock(String name, int quantity, AnimalFood animalFood, AnimalFeed animalFeed) {
        super(name, quantity, animalFood, animalFeed);
    }
}
