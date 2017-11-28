package strategyPattern;

import java.text.Collator;
import java.util.Comparator;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        if (first.getName().length() == second.getName().length()) {
            return Character.compare(first.getName().toLowerCase().charAt(0), second.getName().toLowerCase().charAt(0));
            //return Collator.getInstance().compare(first.getName(), second.getName());
        }
        return first.getName().length() - second.getName().length();
    }
}
