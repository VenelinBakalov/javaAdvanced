package pawInc.centers;

import pawInc.animals.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class Center {

    private String name;
    private List<Animal> storedAnimals;

    public Center(String name) {
        this.setName(name);
        this.storedAnimals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        this.storedAnimals.add(animal);
    }

    public void addAnimals(List<Animal> animals){
        this.storedAnimals.addAll(animals);
    }

    protected void setStoredAnimals(List<Animal> storedAnimals) {
        this.storedAnimals = storedAnimals;
    }

    public List<Animal> getStoredAnimals() {
        return storedAnimals;
    }

    private void setName(String name) {
        this.name = name;
    }

}
