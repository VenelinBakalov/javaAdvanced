package main.bg.softuni.exceptions;

public class InvalidFileNameException extends RuntimeException {

    private static final String FORBIDDEN_SYMBOLS_CONTAINED_IN_NAME =
                    "The given name contains symbols that are not " +
                    "allowed to be used in names of files or folders.";

    public InvalidFileNameException() {
        super(FORBIDDEN_SYMBOLS_CONTAINED_IN_NAME);
    }

    public InvalidFileNameException(String message) {
        super(message);
    }
}
