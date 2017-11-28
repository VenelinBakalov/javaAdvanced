package main.ui;

import main.contracts.ui.Reader;

import java.util.Scanner;


public class ConsoleReader implements Reader{

    private Scanner scanner;

    public ConsoleReader(){
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return this.scanner.nextLine();
    }
}
