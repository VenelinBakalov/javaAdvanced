package sayHello;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 14.3.2017 г..
 */
public class Main {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Bulgarian("Pesho"));
        people.add(new European("Pesho"));
        people.add(new Chinese("Pesho"));

        for (Person person : people) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }
}
