package pawIncExercises.models.centers;

import pawIncExercises.models.animals.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 8.3.2017 г..
 */
public class CleansingCenter extends Center {

    public CleansingCenter(String name) {
        super(name);
    }

    public List<Animal> cleanse() {
        List<Animal> cleansed = new ArrayList<>();
        super.getAnimals().forEach(a -> {
            a.cleanse();
            cleansed.add(a);
        });

        super.removeAnimals(cleansed);
        return cleansed;
    }
}
