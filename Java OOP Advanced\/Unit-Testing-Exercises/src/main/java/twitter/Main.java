package twitter;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Venelin on 3.4.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        ByteArrayOutputStream str = new ByteArrayOutputStream();
        System.setOut(new PrintStream(str));
        Tweet tweet = new Message();
        Client client = new MicrowaveOven(new ServerImpl());
        client.receive(tweet);
        String a = str.toString();
    }
}
