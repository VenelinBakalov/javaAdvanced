package app;

import app.homes.Home;
import app.homes.HomeFactory;
import app.items.Toy;
import app.people.Child;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        int count = 0;

        City kermen = new City();
        HomeFactory homeFactory = new HomeFactory();

        while (!"Democracy".equals(command = reader.readLine().trim())) {
            count++;
            if (command.trim().equals("EVN")) {
                parseEvnCommand(count, kermen);
                continue;
            } else if (command.trim().equals("EVN bill")) {
                parseBillCommand(count, kermen);
                continue;
            }

            parseHomeCommand(command, count, kermen, homeFactory);
        }

        System.out.println("Total population: " + kermen.getPopulation());
    }

    private static void parseHomeCommand(String command, int count, City kermen, HomeFactory homeFactory) {
        String[] childParts = command.split(" Child");
        String commandType = childParts[0].substring(0, childParts[0].indexOf("("));
        Pattern pattern = Pattern.compile("[\\d.]+");
        Matcher matcher = pattern.matcher(childParts[0]);

        List<String> homeArgs = parseHomeArguments(commandType, matcher);
        List<Child> children = new ArrayList<>();
        parseChildren(childParts, pattern, children);

        Home home = homeFactory.createHome(homeArgs, children);
        kermen.addHome(home);

        tryPaySalaries(count, kermen);
    }

    private static List<String> parseHomeArguments(String commandType, Matcher matcher) {
        List<String> homeArgs = new ArrayList<>();
        homeArgs.add(commandType);

        while (matcher.find()) {
            homeArgs.add(matcher.group());
        }
        return homeArgs;
    }

    private static void parseChildren(String[] childParts, Pattern pattern, List<Child> children) {
        Matcher matcher;
        for (int i = 1; i < childParts.length; i++) {
            matcher = pattern.matcher(childParts[i]);
            matcher.find();
            double foodCost = Double.parseDouble(matcher.group());
            List<Toy> toys = new ArrayList<>();
            while (matcher.find()) {
                double toyCost = Double.parseDouble(matcher.group());
                Toy toy = new Toy(toyCost);
                toys.add(toy);
            }

            Child child = new Child(foodCost, toys);
            children.add(child);
        }
    }

    private static void parseBillCommand(int count, City kermen) {
        tryPaySalaries(count, kermen);
        kermen.payBills();
    }

    private static void parseEvnCommand(int count, City kermen) {
        tryPaySalaries(count, kermen);
        System.out.println("Total consumption: " + kermen.getConsumption());
    }

    static void tryPaySalaries(int lineCount, City city) {
        if (lineCount % 3 == 0) {
            city.receiveSalaries();
        }
    }



}
