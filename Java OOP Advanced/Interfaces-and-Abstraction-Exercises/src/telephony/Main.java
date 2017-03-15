package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split(" ");
        String[] websites = reader.readLine().split(" ");
        Smartphone phone = new Smartphone();

        for (String number : numbers) {
            System.out.println(phone.call(number));
        }

        for (String website : websites) {
            System.out.println(phone.browse(website));
        }
    }
}
