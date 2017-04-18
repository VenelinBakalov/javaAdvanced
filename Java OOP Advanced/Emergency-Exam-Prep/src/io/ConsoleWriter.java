package io;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
