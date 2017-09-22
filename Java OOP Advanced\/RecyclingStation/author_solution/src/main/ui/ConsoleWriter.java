package main.ui;

public class ConsoleWriter implements main.contracts.ui.Writer{

    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
