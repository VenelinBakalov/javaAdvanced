package PersonTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> people = new HashSet<>();
        int peopleCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < peopleCount; i++) {
            String[] information = reader.readLine().split(" ");
            String name = information[0];
            int age = Integer.parseInt(information[1]);
            PersonTasks.Person person = new PersonTasks.Person(name, age);
            people.add(person);
        }

        people.stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }



    /*
    1.	Define Class PersonTasks.Person
    public static void main(String[] args) {
        Class person = PersonTasks.Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
     */

    /*
    2.	Creating Constructors
     public static void main(String[] args) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, InstantiationException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        Class personClass = PersonTasks.Person.class;

        Constructor emptyCtor = personClass.getDeclaredConstructor();
        Constructor ageCtor = personClass.getDeclaredConstructor(int.class);
        Constructor nameAgeCtor = personClass.getDeclaredConstructor(String.class, int.class);

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        PersonTasks.Person basePerson = (PersonTasks.Person) emptyCtor.newInstance();
        PersonTasks.Person personWithAge = (PersonTasks.Person) ageCtor.newInstance(age);
        PersonTasks.Person personFull = (PersonTasks.Person) nameAgeCtor.newInstance(name, age);

        System.out.printf("%s %s%n", basePerson.name, basePerson.age);
        System.out.printf("%s %s%n", personWithAge.name, personWithAge.age);
        System.out.printf("%s %s%n", personFull.name, personFull.age);
    }
     */
}
