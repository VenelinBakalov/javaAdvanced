import animals.Animal;
import animals.Cat;
import animals.Dog;
import centers.AdoptionCenter;
import centers.CastrationCenter;
import centers.CleansingCenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class Main {
    private static Map<String, CleansingCenter> cleansingCenters = new HashMap<>();
    private static Map<String, AdoptionCenter> adoptionCenters = new HashMap<>();
    private static Map<String, CastrationCenter> castrationCenters = new HashMap<>();
    private static List<Animal> cleansedAnimals = new ArrayList<>();
    private static List<Animal> adoptedAnimals = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        while (!"Paw Paw Pawah".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(" \\| ");
            String commandType = commandArgs[0];

            switch (commandType) {
                case "RegisterCleansingCenter":
                    registerCleansingCenter(commandArgs);
                    break;
                case "RegisterAdoptionCenter":
                    registerAdoptionCenter(commandArgs);
                    break;
                case "RegisterCastrationCenter":
                    registerCastrationCenter(commandArgs);
                    break;
                case "RegisterDog":
                    registerDog(commandArgs);
                    break;
                case "RegisterCat":
                    registerCat(commandArgs);
                    break;
                case "SendForCleansing":
                    sendForCleansing(commandArgs);
                    break;
                case "Cleanse":
                    cleanse(commandArgs);
                    break;
                case "Adopt":
                    adopt(commandArgs);
                    break;
                case "SendForCastration":
                    sendForCastration(commandArgs);
                    break;
            }
        }

        List<String> adoptedAnimalsStrings = adoptedAnimals.stream().map(Animal::getName).collect(Collectors.toList());
        List<String> cleansedAnimalsStrings = cleansedAnimals.stream().map(Animal::getName).collect(Collectors.toList());
        Collections.sort(adoptedAnimalsStrings);
        Collections.sort(cleansedAnimalsStrings);

        StringBuilder sb = new StringBuilder();
        System.out.println("Paw Incorporative Regular Statistics");
        System.out.println("Adoption Centers: " + adoptionCenters.size());
        System.out.println("Cleansing Centers: " + cleansingCenters.size());
        System.out.print("Adopted Animals: ");
        if (adoptedAnimalsStrings.size() > 0) {
            System.out.println(String.join(", ", adoptedAnimalsStrings));
        } else {
            System.out.println("None");
        }
        System.out.print("Cleansed Animals: ");
                if (cleansedAnimalsStrings.size() > 0) {
                    System.out.println(String.join(", ", cleansedAnimalsStrings));
                } else {
                    System.out.println("None");
                }
        System.out.println("Animals Awaiting Adoption: "
                + adoptionCenters.values().stream().map(c -> c.getStoredAnimals().stream()
                .filter(a -> a.getCleansingStatus().equals("CLEANSED")).count()).reduce((a1, a2) -> a1 + a2).get());
        System.out.println("Animals Awaiting Cleansing: "
                + cleansingCenters.values().stream().map(c -> c.getStoredAnimals().stream()
                .filter(a -> a.getCleansingStatus().equals("UNCLEANSED")).count()).reduce((a1, a2) -> a1 + a2).get());
    }

    private static void sendForCastration(String[] commandArgs) {
        String adoptionCenterName = commandArgs[1];
        String castrationCenterName = commandArgs[2];
        AdoptionCenter adoptionCenter = adoptionCenters.get(adoptionCenterName);
        CastrationCenter castrationCenter = castrationCenters.get(castrationCenterName);
        adoptionCenter.sendForCastration(castrationCenter);
    }

    private static void registerCastrationCenter(String[] commandArgs) {
        String name = commandArgs[1];
        CastrationCenter center = new CastrationCenter(name);
        castrationCenters.put(name, center);
    }

    private static void adopt(String[] commandArgs) {
        String adoptionCenterName = commandArgs[1];
        AdoptionCenter adoptionCenter = adoptionCenters.get(adoptionCenterName);
        adoptionCenter.adopt(adoptedAnimals);
    }

    private static void cleanse(String[] commandArgs) {
        String cleansingCenterName = commandArgs[1];
        CleansingCenter center = cleansingCenters.get(cleansingCenterName);
        center.cleanse();
        List<Animal> currentCenterCleansedAnimals = center.getStoredAnimals();
        currentCenterCleansedAnimals.forEach(a -> {
            AdoptionCenter adoptionCenter = adoptionCenters.get(a.getAdoptionCenter());
            adoptionCenter.addAnimal(a);
        });
        cleansedAnimals.addAll(currentCenterCleansedAnimals);
        currentCenterCleansedAnimals.clear();
    }

    private static void sendForCleansing(String[] commandArgs) {
        String adoptionCenterName = commandArgs[1];
        String cleansingCenterName = commandArgs[2];
        AdoptionCenter adoptionCenter = adoptionCenters.get(adoptionCenterName);
        CleansingCenter cleansingCenter = cleansingCenters.get(cleansingCenterName);
        adoptionCenter.sendForCleanse(cleansingCenter);
    }

    private static void registerCat(String[] commandArgs) {
        String dogName = commandArgs[1];
        int age = Integer.parseInt(commandArgs[2]);
        int intelligenceCoefficient = Integer.parseInt(commandArgs[3]);
        String adoptionCenterName = commandArgs[4];
        Cat cat = new Cat(dogName, age, intelligenceCoefficient, adoptionCenterName);
        AdoptionCenter center = adoptionCenters.get(adoptionCenterName);
        center.addAnimal(cat);
    }

    private static void registerDog(String[] commandArgs) {
        String dogName = commandArgs[1];
        int age = Integer.parseInt(commandArgs[2]);
        int learnedCommands = Integer.parseInt(commandArgs[3]);
        String adoptionCenterName = commandArgs[4];
        Dog dog = new Dog(dogName, age, learnedCommands, adoptionCenterName);
        AdoptionCenter center = adoptionCenters.get(adoptionCenterName);
        center.addAnimal(dog);
    }

    private static void registerAdoptionCenter(String[] commandArgs) {
        String name = commandArgs[1];
        AdoptionCenter center = new AdoptionCenter(name);
        adoptionCenters.put(name, center);
    }

    private static void registerCleansingCenter(String[] commandArgs) {
        String name = commandArgs[1];
        CleansingCenter center = new CleansingCenter(name);
        cleansingCenters.put(name, center);
    }
}
