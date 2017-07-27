package softuni.users.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Venelin on 25.7.2017 г..
 */
@Component
public class EmailValidator implements ConstraintValidator<Email, String> {

    @Override
    public void initialize(Email email) { }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        return email.matches("^[a-zA-Z0-9]+([\\.\\-_]*[a-zA-Z0-9]+)*@[a-zA-Z]+(\\.[a-zA-Z]+)+$");
    }
}
