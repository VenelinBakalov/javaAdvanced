package main.bg.softuni.exceptions;

public class InvalidInputException extends RuntimeException {

    private static final String INVALID_COMMAND_MESSAGE =
            "The command '%s' is invalid";

    public InvalidInputException(String command) {
        super(String.format(INVALID_COMMAND_MESSAGE, command));
    }
}
