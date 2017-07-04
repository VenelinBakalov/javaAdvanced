package advertismentMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by Venelin on 4.7.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String[] phrases = {
                "Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."
        };

        String[] events = {
                "Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."
        };

        String[] authors = {
                "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"
        };

        String[] cities = {
                "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"
        };

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int messageCount = Integer.parseInt(reader.readLine());
        Random rnd = new Random();

        for (int i = 0; i < messageCount; i++) {
            String phrase = phrases[rnd.nextInt(phrases.length)];
            String event = events[rnd.nextInt(events.length)];
            String author = authors[rnd.nextInt(authors.length)];
            String city = cities[rnd.nextInt(cities.length)];

            System.out.println(String.format("%s %s %s - %s", phrase, event, author, city));
        }
    }
}
