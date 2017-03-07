package centers;

import animals.Animal;

import java.util.List;
import java.util.Map;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class CleansingCenter extends Center {
    private static final String CLEANSED_STATUS = "CLEANSED";

    public CleansingCenter(String name) {
        super(name);
    }

    public void cleanse(List<Animal> cleansedAnimals, Map<String, AdoptionCenter> adoptionCenters){
        super.getStoredAnimals().forEach(a -> a.setCleansingStatus(CLEANSED_STATUS));
        super.getStoredAnimals().forEach(a -> {
            AdoptionCenter adoptionCenter = adoptionCenters.get(a.getAdoptionCenter());
            adoptionCenter.addAnimal(a);
        });
        cleansedAnimals.addAll(super.getStoredAnimals());
        super.getStoredAnimals().clear();
    }
}
