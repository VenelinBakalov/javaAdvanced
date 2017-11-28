package strategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        Set<Person> nameSet = new TreeSet<>(new PersonNameComparator());
        Set<Person> ageSet = new TreeSet<>(new PersonAgeComparator());

        for (int i = 0; i < count; i++) {
            String[] personArgs = reader.readLine().split(" ");
            Person person = new Person(personArgs[0], Integer.parseInt(personArgs[1]));
            nameSet.add(person);
            ageSet.add(person);
        }

        nameSet.forEach(System.out::println);
        ageSet.forEach(System.out::println);
    }
}
