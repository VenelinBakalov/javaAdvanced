package bg.softuni.exceptions;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class InvalidStringException extends RuntimeException {

    private static final String NULL_OR_EMPTY_VALUE = "The value of the variable CANNOT be null or empty!";

    public InvalidStringException() {
        super(NULL_OR_EMPTY_VALUE);
    }

    public InvalidStringException(String message) {
        super(message);
    }
}
