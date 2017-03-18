package threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 18.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstArgs = reader.readLine().split(" ");
        Threeuple<String, String, String> first = new Threeuple<>(firstArgs[0] + " " + firstArgs[1], firstArgs[2], firstArgs[3]);
        System.out.println(first);

        String[] secondArgs = reader.readLine().split(" ");
        boolean isDrunk = false;
        if (secondArgs[2].equals("drunk")) {
            isDrunk = true;
        }
        Threeuple<String, Integer, Boolean> second = new Threeuple<>(secondArgs[0], Integer.parseInt(secondArgs[1]), isDrunk);
        System.out.println(second);

        String[] thirdArgs = reader.readLine().split(" ");
        Threeuple<String, Double, String> third = new Threeuple<>(thirdArgs[0], Double.valueOf(thirdArgs[1]), thirdArgs[2]);
        System.out.println(third);
    }
}
