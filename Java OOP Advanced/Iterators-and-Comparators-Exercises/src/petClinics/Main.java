package petClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Venelin on 25.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Clinic> clinics = new HashMap<>();
        Map<String, Pet> pets = new HashMap<>();
        int commandCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < commandCount; i++) {
            String[] commandArgs = reader.readLine().split(" ");
            String commandType = commandArgs[0];

            switch (commandType) {
                case "Create":
                    executeCreateCommand(clinics, pets, commandArgs);
                    break;
                case "Add":
                    executeAddPetCommand(clinics, pets, commandArgs);
                    break;
                case "Release":
                    executeReleaseCommand(clinics, commandArgs);
                    break;
                case "HasEmptyRooms":
                    executeHasEmptyRoomsCommand(clinics, commandArgs);
                    break;
                case "Print":
                    executePrintCommand(clinics, commandArgs);
                    break;
            }
        }
    }

    private static void executePrintCommand(Map<String, Clinic> clinics, String[] commandArgs) {
        Clinic clinic = clinics.get(commandArgs[1]);
        if (commandArgs.length == 3) {
            int roomIndex = Integer.parseInt(commandArgs[2]);
            System.out.println(clinic.print(roomIndex));
        } else {
            System.out.println(clinic.print());
        }
    }

    private static void executeHasEmptyRoomsCommand(Map<String, Clinic> clinics, String[] commandArgs) {
        Clinic clinic = clinics.get(commandArgs[1]);
        System.out.println(clinic.hasEmptyRooms());
    }

    private static void executeReleaseCommand(Map<String, Clinic> clinics, String[] commandArgs) {
        Clinic clinic = clinics.get(commandArgs[1]);
        System.out.println(clinic.releasePet());
    }

    private static void executeAddPetCommand(Map<String, Clinic> clinics, Map<String, Pet> pets, String[] commandArgs) {
        Pet pet = pets.get(commandArgs[1]);
        Clinic clinic = clinics.get(commandArgs[2]);
        System.out.println(clinic.addPet(pet));
    }

    private static void executeCreateCommand(Map<String, Clinic> clinics, Map<String, Pet> pets, String[] commandArgs) {
        if (commandArgs.length == 5) {
            String petName = commandArgs[2];
            Pet pet = new Pet(petName, Integer.parseInt(commandArgs[3]), commandArgs[4]);
            pets.put(petName, pet);
        } else {
            try {
                String clinicName = commandArgs[2];
                Clinic clinic = new Clinic(clinicName, Integer.parseInt(commandArgs[3]));
                clinics.put(clinicName, clinic);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
