package strategyPattern;

import java.util.Comparator;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
        return first.getAge() - second.getAge();
    }
}
