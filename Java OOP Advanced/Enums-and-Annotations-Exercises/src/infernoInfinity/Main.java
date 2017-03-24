package infernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Venelin on 24.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Weapon> weapons = new HashMap<>();
        String command;

        while (!"END".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(";");
            String commandType = commandArgs[0];

            try {
                switch (commandType) {
                    case "Create":
                        String weaponType = commandArgs[1];
                        String weaponName = commandArgs[2];
                        Weapon weapon = new Weapon(weaponName, WeaponType.valueOf(weaponType));
                        weapons.put(weaponName, weapon);
                        break;
                    case "Add":
                        weapons.get(commandArgs[1]).addGem(Integer.parseInt(commandArgs[2]), GemType.valueOf(commandArgs[3]));
                        break;
                    case "Remove":
                        weapons.get(commandArgs[1]).removeGem(Integer.parseInt(commandArgs[2]));
                        break;
                    case "Compare":
                        Weapon firstWeapon = weapons.get(commandArgs[1]);
                        Weapon secondWeapon = weapons.get(commandArgs[2]);
                        if (firstWeapon.compareTo(secondWeapon) >= 0) {
                            firstWeapon.print();
                        } else {
                            secondWeapon.print();
                        }
                        break;
                    case "Print":
                        System.out.println(weapons.get(commandArgs[1]).toString().trim());
                        break;
                    default:
                        executeAnnotationCommands(commandType);
                        break;
                }
            } catch (IllegalArgumentException timonAndPumbaException) { }
        }
    }

    private static void executeAnnotationCommands(String commandType) {
        Class<Weapon> weaponClass = Weapon.class;
        Information annotation = weaponClass.getAnnotation(Information.class);

        switch (commandType) {
            case "Author":
                System.out.println("Author: " + annotation.author());
                break;
            case "Revision":
                System.out.println("Revision: " + annotation.revision());
                break;
            case "Description":
                System.out.println("Class description: " + annotation.description());
                break;
            case "Reviewers":
                System.out.println(String.format("Reviewers: %s", String.join(", ", annotation.reviewers())));
                break;
        }
    }
}
