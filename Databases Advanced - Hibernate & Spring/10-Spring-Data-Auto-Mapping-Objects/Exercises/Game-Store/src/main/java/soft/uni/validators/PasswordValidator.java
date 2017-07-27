package soft.uni.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Venelin on 27.7.2017 г..
 */
@Component
public class PasswordValidator implements ConstraintValidator<Password, String> {

    private int minLength;
    private boolean containsLowercase;
    private boolean containsUppercase;
    private boolean containsDigit;

    @Override
    public void initialize(Password password) {
        this.minLength = password.minLength();
        this.containsDigit = password.containsDigit();
        this.containsLowercase = password.containsLowercase();
        this.containsUppercase = password.containsUppercase();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        if (password.length() < this.minLength) {
            return false;
        }

        Pattern lowerCasePattern = Pattern.compile("[a-z]");
        Matcher lowerCaseRegex = lowerCasePattern.matcher(password);

        if (!lowerCaseRegex.find() && this.containsLowercase) {
            return false;
        }

        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Matcher upperCaseRegex = upperCasePattern.matcher(password);

        if (!upperCaseRegex.find() && this.containsUppercase) {
            return false;
        }

        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitRegex = digitPattern.matcher(password);

        if (!digitRegex.find() && this.containsDigit) {
            return false;
        }

        return true;
    }
}
