package tuple;

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
        Tuple<String, String> first = new Tuple<>(firstArgs[0] + " " + firstArgs[1], firstArgs[2]);
        System.out.println(first);

        String[] secondArgs = reader.readLine().split(" ");
        Tuple<String, Integer> second = new Tuple<>(secondArgs[0], Integer.parseInt(secondArgs[1]));
        System.out.println(second);

        String[] thirdArgs = reader.readLine().split(" ");
        Tuple<Integer, Double> third = new Tuple<>(Integer.parseInt(thirdArgs[0]), Double.parseDouble(thirdArgs[1]));
        System.out.println(third);
    }
}
