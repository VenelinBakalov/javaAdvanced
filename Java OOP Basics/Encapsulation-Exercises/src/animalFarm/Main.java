package animalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String chickenName = reader.readLine();
        int chickenAge = Integer.parseInt(reader.readLine());

        try {
            Chicken chicken = new Chicken(chickenName, chickenAge);
            System.out.println(String.format("Chicken %s (age %s) can produce %.0f eggs per day.", chicken.getName(), chicken.getAge(), chicken.getProductPerDay()));
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }
    }
}
