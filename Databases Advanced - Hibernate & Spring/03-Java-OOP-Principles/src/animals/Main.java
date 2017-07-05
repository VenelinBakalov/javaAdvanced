package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String animalType;

        while (!"Beast!".equals(animalType = reader.readLine())) {
            String[] animalArgs = reader.readLine().split("\\s+");
            String name = animalArgs[0];
            Integer age = Integer.parseInt(animalArgs[1]);

            try {
                Animal animal = null;
                switch (animalType.toLowerCase()) {
                    case "dog":
                        animal = new Dog(name, age, animalArgs[2]);
                        break;
                    case "cat":
                        animal = new Cat(name, age, animalArgs[2]);
                        break;
                    case "frog":
                        animal = new Frog(name, age, animalArgs[2]);
                        break;
                    case "kitten":
                        animal = new Kitten(name, age);
                        break;
                    case "tomcat":
                        animal = new Tomcat(name, age);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input!");
                }
                System.out.println(animal);
                System.out.println(animal.produceSound());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
