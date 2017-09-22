package comparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        String command;

        while (!"END".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(" ");
            Person person = new Person(commandArgs[0], Integer.parseInt(commandArgs[1]), commandArgs[2]);
            people.add(person);
        }
        int index = Integer.parseInt(reader.readLine());
        if (index >= people.size()) {
            System.out.println("No matches");
            return;
        }
        Person person = people.get(index);
        int equal = Math.toIntExact(people.stream().filter(p -> p.compareTo(person) == 0).count());

        if (equal == 0) {
            System.out.println("No matches");
            return;
        }

        System.out.println(String.format("%d %d %d", equal, people.size() - equal, people.size()));
    }
}
