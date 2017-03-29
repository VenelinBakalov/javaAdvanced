package bg.softuni.exceptions;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class InvalidPathException extends RuntimeException {

    private static final String INVALID_PATH = "The source does not exist.";

    public InvalidPathException() {
        super(INVALID_PATH);
    }

    public InvalidPathException(String message) {
        super(message);
    }
}
