package pawInc.centers;

import pawInc.animals.Animal;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class AdoptionCenter extends Center {

    public AdoptionCenter(String name) {
        super(name);
    }

    public void sendForCastration(CastrationCenter castrationCenter) {
        super.getStoredAnimals().forEach(castrationCenter::addAnimal);
        super.getStoredAnimals().clear();
    }

    public void sendForCleanse(CleansingCenter cleansingCenter) {
        super.getStoredAnimals().stream()
                .filter(a -> a.getCleansingStatus().equals("UNCLEANSED"))
                .forEach(cleansingCenter::addAnimal);
        super.setStoredAnimals(super.getStoredAnimals().stream()
                .filter(a -> a.getCleansingStatus().equals("CLEANSED")).collect(Collectors.toList()));
    }

    public void adopt(List<Animal> adoptedAnimals) {
        adoptedAnimals.addAll(super.getStoredAnimals().stream()
                .filter(a -> a.getCleansingStatus().equals("CLEANSED"))
                .collect(Collectors.toList()));
        super.setStoredAnimals(
                super.getStoredAnimals().stream()
                        .filter(a -> a.getCleansingStatus().equals("UNCLEANSED"))
                        .collect(Collectors.toList()));
    }
}
