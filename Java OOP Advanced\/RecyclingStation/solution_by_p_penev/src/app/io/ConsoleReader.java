package app.io;

import java.util.Scanner;

public class ConsoleReader implements Reader {

    private Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String read() {
        return this.scanner.nextLine();
    }
}
