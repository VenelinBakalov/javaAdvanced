package mordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 3.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] foods = reader.readLine().split("\\s+");
        Gandalf gandalf = new Gandalf();
        for (String food : foods) {
                gandalf.eat(food);
        }

        System.out.println(gandalf);
    }
}
