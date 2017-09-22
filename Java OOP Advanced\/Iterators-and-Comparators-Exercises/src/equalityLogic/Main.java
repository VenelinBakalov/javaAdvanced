package equalityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Set<Person> tree = new TreeSet<>();
        Set<Person> hash = new HashSet<>();

        for (int i = 0; i < count; i++) {
            String[] personArgs = reader.readLine().split(" ");
            String name = personArgs[0];
            int age = Integer.parseInt(personArgs[1]);

            Person person = new Person(name, age);
            tree.add(person);
            hash.add(person);
        }

        System.out.println(tree.size());
        System.out.println(hash.size());
    }
}
