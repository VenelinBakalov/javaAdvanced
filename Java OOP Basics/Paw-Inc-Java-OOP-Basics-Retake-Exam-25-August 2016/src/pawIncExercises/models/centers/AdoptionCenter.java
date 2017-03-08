package pawIncExercises.models.centers;

import pawIncExercises.models.animals.Animal;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 8.3.2017 г..
 */
public class AdoptionCenter extends Center {

    public AdoptionCenter(String name) {
        super(name);
    }

    public void sendForCleansing(CleansingCenter center) {
        List<Animal> animals = super.getAnimals().stream()
                .filter(a -> !a.isCleansed())
                .collect(Collectors.toList());

        center.registerAll(animals);
        super.removeAnimals(animals);
    }

    public void sendForCastration(CastrationCenter center) {
        List<Animal> animals = super.getAnimals().stream()
                .filter(a -> !a.isCleansed())
                .collect(Collectors.toList());

        super.removeAnimals(animals);
        center.registerAll(animals);
    }

    public List<Animal> adopt() {
        List<Animal> animals = super.getAnimals().stream()
                .filter(Animal::isCleansed)
                .collect(Collectors.toList());

        super.removeAnimals(animals);
        return animals;
    }
}
