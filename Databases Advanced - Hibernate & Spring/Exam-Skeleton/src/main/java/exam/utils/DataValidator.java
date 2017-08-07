package exam.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public final class DataValidator {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private DataValidator() {
    }

    public static <T> boolean isValid(T t) {
        return validator.validate(t).size() == 0;
    }

    public static <T> String getInvalidParameterMessage (T target) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraints = factory.getValidator().validate(target);

        for (ConstraintViolation<T> constraint : constraints) {
            return constraint.getMessage();
        }

        return null;
    }

    public static <T> Boolean checkIsValid (T target) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraints = factory.getValidator().validate(target);

        for (ConstraintViolation<T> constraint : constraints) {
            return false;
        }

        return true;
    }
}
