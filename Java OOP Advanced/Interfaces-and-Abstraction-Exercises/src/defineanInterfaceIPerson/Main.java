package defineanInterfaceIPerson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Class[] citizenInterfaces = Citizen.class.getInterfaces();
        if (Arrays.asList(citizenInterfaces).contains(Person.class)) {
            Method[] fields = Person.class.getDeclaredMethods();
            System.out.println(fields.length);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            int age = Integer.parseInt(reader.readLine());
            Person person = new Citizen(name, age);
            System.out.println(person.getName());
            System.out.println(person.getAge());
        }
    }
}
