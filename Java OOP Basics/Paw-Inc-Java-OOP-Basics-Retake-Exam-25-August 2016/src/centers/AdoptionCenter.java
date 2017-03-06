package centers;

import java.util.stream.Collectors;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class AdoptionCenter extends Center {

    public AdoptionCenter(String name) {
        super(name);
    }

    public void sendForCleanse(CleansingCenter cleansingCenter) {
        super.getStoredAnimals().stream()
                .filter(a -> a.getCleansingStatus().equals("UNCLEANSED"))
                .forEach(cleansingCenter::addAnimal);
        super.getStoredAnimals().clear();
    }

    public void adopt() {
        this.setStoredAnimals(this.getStoredAnimals()
                .stream().filter(a -> a.getCleansingStatus().equals("UNCLEANSED"))
                .collect(Collectors.toList()));
    }
}
