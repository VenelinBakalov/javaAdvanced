package app.utils;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public final class DataValidator {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private DataValidator() {
    }

    public static <T> boolean isValid(T t) {
        return t != null && validator.validate(t).size() == 0;
    }

}
