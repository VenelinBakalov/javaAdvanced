package io;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public class ConsoleWriter implements Writer {

    @Override
    public void write(String text) {
        System.out.println(text);
    }

    @Override
    public void write(String text, Object... params) {
        System.out.println(String.format(text, params));
    }
}
