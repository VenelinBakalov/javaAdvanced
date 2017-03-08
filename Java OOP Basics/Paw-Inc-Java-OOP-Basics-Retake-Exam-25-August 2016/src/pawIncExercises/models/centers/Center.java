package pawIncExercises.models.centers;

import pawIncExercises.models.animals.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Venelin on 8.3.2017 г..
 */
public abstract class Center {

    private String name;
    private List<Animal> animals;

    protected Center(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public void register(Animal animal) {
        this.animals.add(animal);
    }

    public void registerAll(List<Animal> animals) {
        this.animals.addAll(animals);
    }

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(this.animals);
    }

    public void removeAnimals(List<Animal> animals) {
        this.animals.removeAll(animals);
    }

    public String getName() {
        return name;
    }
}
