package pawInc.centers;

import pawInc.animals.Animal;

import java.util.List;
import java.util.Map;

/**
 * Created by Venelin on 7.3.2017 г..
 */
public class CastrationCenter extends Center {

    public CastrationCenter(String name) {
        super(name);
    }

    public void castrate(List<Animal> castratedAnimals, Map<String, AdoptionCenter> adoptionCenters) {
        castratedAnimals.addAll(super.getStoredAnimals());
        super.getStoredAnimals().forEach(a -> {
            AdoptionCenter center = adoptionCenters.get(a.getAdoptionCenter());
            center.addAnimal(a);
        });
        super.getStoredAnimals().clear();
    }
}
