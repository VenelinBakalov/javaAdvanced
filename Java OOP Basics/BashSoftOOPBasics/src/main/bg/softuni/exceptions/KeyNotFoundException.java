package main.bg.softuni.exceptions;

public class KeyNotFoundException extends RuntimeException {


    private static final String NOT_ENROLLED_IN_COURSE =
            "StudentImpl must be enrolled in a course before you set his mark.";

    public KeyNotFoundException() {
        super(NOT_ENROLLED_IN_COURSE);
    }

    public KeyNotFoundException(String message) {
        super(message);
    }
}
