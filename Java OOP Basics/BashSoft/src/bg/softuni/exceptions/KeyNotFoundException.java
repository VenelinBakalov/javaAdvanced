package bg.softuni.exceptions;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class KeyNotFoundException extends RuntimeException {

    private static final String NOT_ENROLLED_IN_COURSE = "Student must be enrolled in a course before you set his mark.";

    public KeyNotFoundException() {
        super(NOT_ENROLLED_IN_COURSE);
    }
}
