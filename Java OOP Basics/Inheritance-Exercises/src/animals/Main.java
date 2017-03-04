package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 4.3.2017 г..
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
                switch (animalType.toLowerCase()) {
                    case "dog":
                        Dog dog = new Dog(name, age, animalArgs[2]);
                        System.out.println(dog);
                        dog.produceSound();
                        break;
                    case "cat":
                        Cat cat = new Cat(name, age, animalArgs[2]);
                        System.out.println(cat);
                        cat.produceSound();
                        break;
                    case "frog":
                        Frog frog = new Frog(name, age, animalArgs[2]);
                        System.out.println(frog);
                        frog.produceSound();
                        break;
                    case "kitten":
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten);
                        kitten.produceSound();
                        break;
                    case "tomcat":
                        Tomcat tomcat = new Tomcat(name, age);
                        System.out.println(tomcat);
                        tomcat.produceSound();
                        break;
                    case "animal":
                        Animal animal = new Animal(name, age, animalArgs[2]);
                        System.out.println(animal);
                        animal.produceSound();
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
