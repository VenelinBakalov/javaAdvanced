package app.io;

import org.springframework.stereotype.Component;

/**
 * Created by Venelin on 23.4.2017 г..
 */
@Component
public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) {
        System.out.println(String.format(format, params));
    }
}
