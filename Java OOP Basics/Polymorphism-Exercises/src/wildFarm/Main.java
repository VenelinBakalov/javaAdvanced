package wildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 5.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String animalInfo;

        while (!"End".equals(animalInfo = reader.readLine())) {
            String[] animalArgs = animalInfo.split(" ");
            String animalType = animalArgs[0];
            String name = animalArgs[1];
            Double weight = Double.parseDouble(animalArgs[2]);
            String livingRegion = animalArgs[3];

            try {
                Animal animal;
                switch (animalType) {
                    case "Mouse":
                        animal = new Mouse(name, animalType, weight, livingRegion);
                        break;
                    case "Zebra":
                        animal = new Zebra(name, animalType, weight, livingRegion);
                        break;
                    case "Cat":
                        animal = new Cat(name, animalType, weight, livingRegion, animalArgs[4]);
                        break;
                    case "Tiger":
                        animal = new Tiger(name, animalType, weight, livingRegion);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid animal type!");
                }

                String[] foodArgs = reader.readLine().split(" ");
                String foodType = foodArgs[0];
                Integer quantity = Integer.parseInt(foodArgs[1]);

                Food food;
                switch (foodType) {
                    case "Vegetable":
                        food = new Vegetable(quantity);
                        break;
                    case "Meat":
                        food = new Meat(quantity);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid food type!");
                }

                animal.makeSound();
                try {
                    animal.eat(food);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(animal);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
