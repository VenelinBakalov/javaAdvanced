package p01_system_resources;

/**
 * Created by Venelin on 6.4.2017 г..
 */
public class ConsoleWriter implements Writer {

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
