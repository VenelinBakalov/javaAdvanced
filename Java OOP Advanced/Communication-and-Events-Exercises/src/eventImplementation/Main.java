package eventImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 13.4.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Dispatcher dispatcher = new Dispatcher();
        Handler handler = new Handler();
        dispatcher.addNameChangeListener(handler);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;

        while (!"End".equals(name = reader.readLine())) {
            NameChange event = new NameChange(name);
            dispatcher.fireNameChangeEvent(event);
        }
    }
}
