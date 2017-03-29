package bg.softuni.io;

import java.util.List;

public class OutputWriter {

    public static void writeMessage(String message)
    {
        System.out.printf("%s", message);
    }

    public static void writeMessageOnNewLine(String message)
    {
        System.out.println(message);
    }

    public static void writeEmptyLine()
    {
        System.out.println();
    }

    public static void displayException(String message)
    {
        System.out.println("\u001B[31m" + message + "\u001B[0m");
    }

    public static void printStudent(String name, Double mark) {
        String output = String.format("%s - %f", name, mark);
        OutputWriter.writeMessageOnNewLine(output);
    }
}

