package hell.entities.io;

import hell.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public class ConsoleReader implements InputReader {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String readLine() {
        String input = null;

        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }
}
