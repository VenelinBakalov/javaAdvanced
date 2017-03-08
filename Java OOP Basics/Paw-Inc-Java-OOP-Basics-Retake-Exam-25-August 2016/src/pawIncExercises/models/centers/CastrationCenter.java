package pawIncExercises.models.centers;

import pawIncExercises.models.animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 8.3.2017 г..
 */
public class CastrationCenter extends Center {

    public CastrationCenter(String name) {
        super(name);
    }

    public List<Animal> castrate() {
        List<Animal> castrated = new ArrayList<>(super.getAnimals());
        super.removeAnimals(castrated);
        return castrated;
    }
}
