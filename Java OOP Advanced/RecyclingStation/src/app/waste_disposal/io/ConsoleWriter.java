package app.waste_disposal.io;

/**
 * Created by Venelin on 19.4.2017 г..
 */
public class ConsoleWriter implements Writer {
    @Override
    public void write(String text) {
        System.out.println(text);
    }
}
