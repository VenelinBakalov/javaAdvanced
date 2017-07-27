package soft.uni.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Venelin on 27.7.2017 г..
 */
@Component
public class EmailValidator implements ConstraintValidator<Email, String> {

    @Override
    public void initialize(Email email) { }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        return email.contains("@") && email.contains(".");

    }
}
