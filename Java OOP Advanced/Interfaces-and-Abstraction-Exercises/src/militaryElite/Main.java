package militaryElite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, ISoldier> soldiers = new LinkedHashMap<>();

        String command;

        while (!"End".equals(command = reader.readLine())) {
            String[] commandArgs = command.split("\\s+");
            ISoldier soldier = null;
            String type = commandArgs[0];
            try {
                switch (type) {
                    case "Private":
                        soldier = new Private(commandArgs[1], commandArgs[2], commandArgs[3], Double.parseDouble(commandArgs[4]));
                        break;
                    case "LeutenantGeneral":
                        List<ISoldier> privates = new ArrayList<>();
                        for (int i = 5; i < commandArgs.length; i++) {
                            privates.add(soldiers.get(commandArgs[i]));
                        }
                        soldier = new LeutenantGeneral(commandArgs[1], commandArgs[2], commandArgs[3], Double.parseDouble(commandArgs[4]), privates);
                        break;
                    case "Engineer":
                        List<Repair> repairs = new ArrayList<>();
                        for (int i = 6; i < commandArgs.length - 1; i += 2) {
                            repairs.add(new Repair(commandArgs[i], Integer.parseInt(commandArgs[i + 1])));
                        }
                        soldier = new Engineer(commandArgs[1], commandArgs[2], commandArgs[3], Double.parseDouble(commandArgs[4]), commandArgs[5], repairs);
                        break;
                    case "Commando":
                        List<Mission> missions = new ArrayList<>();
                        for (int i = 6; i < commandArgs.length - 1; i += 2) {
                            try {
                                Mission mission = new Mission(commandArgs[i], commandArgs[i + 1]);
                                missions.add(mission);
                            } catch (IllegalArgumentException e) {
                            }
                        }
                        soldier = new Commando(commandArgs[1], commandArgs[2], commandArgs[3], Double.parseDouble(commandArgs[4]), commandArgs[5], missions);
                        break;
                    case "Spy":
                        soldier = new Spy(commandArgs[1], commandArgs[2], commandArgs[3], commandArgs[4]);
                        break;
                    default:
                        continue;
                }

                soldiers.put(commandArgs[1], soldier);
            } catch (IllegalArgumentException e) {}
        }

        soldiers.values().forEach(System.out::println);
    }
}
