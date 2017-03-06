import animals.Animal;
import animals.Cat;
import animals.Dog;
import centers.AdoptionCenter;
import centers.CleansingCenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class Main {
    private static Map<String, CleansingCenter> cleansingCenters = new HashMap<>();
    private static Map<String, AdoptionCenter> adoptionCenters = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        while (!"Paw Paw Pawah".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(" | ");
            String commandType = commandArgs[0];

            switch (commandType) {
                case "RegisterCleansingCenter":
                    registerCleansingCenter(commandArgs);
                    break;
                case "RegisterAdoptionCenter":
                    registerAdoptionCenter(commandArgs);
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
            }
        }
    }

    private static void adopt(String[] commandArgs) {
        String adoptionCenterName = commandArgs[1];
        AdoptionCenter adoptionCenter = adoptionCenters.get(adoptionCenterName);
        adoptionCenter.adopt();
    }

    private static void cleanse(String[] commandArgs) {
        String cleansingCenterName = commandArgs[1];
        CleansingCenter center = cleansingCenters.get(cleansingCenterName);
        center.cleanse();
        List<Animal> cleansedAnimals = center.getStoredAnimals();
        cleansedAnimals.forEach(a -> {
            AdoptionCenter adoptionCenter = adoptionCenters.get(a.getAdoptionCenter());
            adoptionCenter.addAnimal(a);
        });
        cleansedAnimals.clear();
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
