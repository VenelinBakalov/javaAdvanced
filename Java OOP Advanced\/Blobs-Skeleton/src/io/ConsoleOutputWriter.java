package io;

import interfaces.OutputWriter;

/**
 * Created by Venelin on 8.4.2017 г..
 */
public class ConsoleOutputWriter implements OutputWriter {

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) {
        System.out.println(String.format(format, params));
    }
}
