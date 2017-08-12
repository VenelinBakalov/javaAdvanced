package app.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Venelin on 12.8.2017 г..
 */
public class PhoneValidator implements ConstraintValidator<Telephone, String> {

    @Override
    public void initialize(Telephone telephone) {

    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        return phone.matches("^[+]\\d{1,3}\\/\\d{8,10}$");
    }
}
