package pawIncExercises.models;

import pawIncExercises.models.animals.Animal;
import pawIncExercises.models.animals.Cat;
import pawIncExercises.models.animals.Dog;
import pawIncExercises.models.centers.AdoptionCenter;
import pawIncExercises.models.centers.CastrationCenter;
import pawIncExercises.models.centers.CleansingCenter;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 8.3.2017 г..
 */
public class AnimalCenterManager {

    private Map<String, AdoptionCenter> adoptionCenters;
    private Map<String, CleansingCenter> cleansingCenters;
    private Map<String, CastrationCenter> castrationCenters;
    private List<Animal> cleansedAnimals;
    private List<Animal> adoptedAnimals;
    private List<Animal> castratedAnimals;

    public AnimalCenterManager() {
        this.adoptionCenters = new HashMap<>();
        this.cleansingCenters = new HashMap<>();
        this.castrationCenters = new HashMap<>();
        this.cleansedAnimals = new ArrayList<>();
        this.adoptedAnimals = new ArrayList<>();
        this.castratedAnimals = new ArrayList<>();
    }

    public void registerCleansingCenter(String name) {
        CleansingCenter cleansingCenter = new CleansingCenter(name);
        this.cleansingCenters.put(name, cleansingCenter);
    }

    public void registerAdoptionCenter(String name) {
        AdoptionCenter adoptionCenter = new AdoptionCenter(name);
        this.adoptionCenters.put(name, adoptionCenter);
    }

    public void registerCastrationCenter(String name) {
        CastrationCenter castrationCenter = new CastrationCenter(name);
        this.castrationCenters.put(name, castrationCenter);
    }
    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Dog dog = new Dog(name, age, adoptionCenterName, learnedCommands);
        this.adoptionCenters.get(adoptionCenterName).register(dog);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Cat cat = new Cat(name, age, adoptionCenterName, intelligenceCoefficient);
        this.adoptionCenters.get(adoptionCenterName).register(cat);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);
        this.adoptionCenters.get(adoptionCenterName).sendForCleansing(cleansingCenter);
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName) {
        CastrationCenter castrationCenter = this.castrationCenters.get(castrationCenterName);
        this.adoptionCenters.get(adoptionCenterName).sendForCastration(castrationCenter);
    }

    public void cleanse(String cleansingCenterName) {
        List<Animal> cleansedAnimals = this.cleansingCenters.get(cleansingCenterName).cleanse();
        for (Animal cleansedAnimal : cleansedAnimals) {
            this.adoptionCenters.get(cleansedAnimal.getAdoptionCenter()).register(cleansedAnimal);
        }

        this.cleansedAnimals.addAll(cleansedAnimals);
    }

    public void castrate(String castrationCenter) {
        List<Animal> castratedAnimals = this.castrationCenters.get(castrationCenter).castrate();
        for (Animal castratedAnimal : castratedAnimals) {
            this.adoptionCenters.get(castratedAnimal.getAdoptionCenter()).register(castratedAnimal);
        }

        this.castratedAnimals.addAll(castratedAnimals);
    }

    public void adopt(String adoptionCenterName) {
        List<Animal> adoptedAnimals = this.adoptionCenters.get(adoptionCenterName).adopt();
        this.adoptedAnimals.addAll(adoptedAnimals);
    }

    public void printCastrationStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paw Inc. Regular Castration Statistics\n");
        sb.append(String.format("Castration Centers: %s\n", this.castrationCenters.size()));
        sb.append(String.format("Castrated Animals: %s", getSortedAnimals(this.castratedAnimals)));
        System.out.println(sb.toString());
    }

    public void printStatistics() {

        StringBuilder sb = new StringBuilder();
        sb.append("Paw Incorporative Regular Statistics\n");
        sb.append(String.format("Adoption Centers: %d\n", this.adoptionCenters.size()));
        sb.append(String.format("Cleansing Centers: %d\n", this.cleansingCenters.size()));
        sb.append(String.format("Adopted Animals: %s\n", getSortedAnimals(this.adoptedAnimals)));
        sb.append(String.format("Cleansed Animals: %s\n", getSortedAnimals(this.cleansedAnimals)));
        sb.append(String.format("Animals Awaiting Adoption: %d\n", getAwaitingAdoptionCount()));
        sb.append(String.format("Animals Awaiting Cleansing: %d\n", getAwaitingCleansingCount()));

        System.out.println(sb.toString());
    }

    public String getSortedAnimals(List<Animal> animals) {
        if (animals.isEmpty()) {
            return "None";
        }

        List<String> sorted = animals.stream()
                .map(Animal::getName)
                .sorted(Collator.getInstance())
                .collect(Collectors.toList());

        return String.join(", ", sorted);
    }

    public int getAwaitingAdoptionCount() {
        int count = this.adoptionCenters.values().stream()
                .flatMap(c -> c.getAnimals().stream())
                .filter(Animal::isCleansed)
                .collect(Collectors.toList())
                .size();
        return count;
    }

    public int getAwaitingCleansingCount() {
        return this.cleansingCenters.values().stream()
                .flatMap(c -> c.getAnimals().stream())
                .collect(Collectors.toList())
                .size();
    }
}
