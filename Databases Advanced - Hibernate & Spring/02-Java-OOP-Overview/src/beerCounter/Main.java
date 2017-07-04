package beerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Venelin on 4.7.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                String input = reader.readLine();
                if ("End".equals(input)) break;

                int[] bottlesCount = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
                BeerCounter.buyBeer(bottlesCount[0]);
                BeerCounter.drinkBeer(bottlesCount[1]);
            }
        } catch (Exception e) {}

        System.out.println(BeerCounter.getBeerInStock() + " " + BeerCounter.getBeersDrankCount());
    }
}
