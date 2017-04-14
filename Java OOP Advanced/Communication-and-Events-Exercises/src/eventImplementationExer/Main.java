package eventImplementationExer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        Dispatcher dispatcher = new Dispatcher();
        NameChangeListener handler = new Handler();
        dispatcher.addNameChangeListener(handler);

        while (!"End".equals(line = reader.readLine())) {
            dispatcher.setName(line);
        }
    }
}
