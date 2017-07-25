package softuni.users.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Venelin on 25.7.2017 г..
 */
@Component
public class PasswordValidator implements ConstraintValidator<Password, String> {

    private boolean containsDigit;
    private boolean containsUppercase;
    private boolean containsLowercase;
    private boolean containsSpecialSymbol;
    private int minLength;
    private int maxLength;

    @Override
    public void initialize(Password password) {
        this.minLength = password.minLength();
        this.maxLength = password.maxLength();
        this.containsDigit = password.containsDigit();
        this.containsUppercase = password.containsUppercase();
        this.containsLowercase = password.containsLowercase();
        this.containsSpecialSymbol = password.containsSpecialSymbol();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        if (password.length() < this.minLength || password.length() > this.maxLength) {
            return false;
        }

        Pattern pattern = Pattern.compile("[a-z]");
        Matcher regex = pattern.matcher(password);

        if (!regex.find() && this.containsLowercase) {
            return false;
        }

        Pattern patternTwo = Pattern.compile("[A-Z]");
        regex = patternTwo.matcher(password);

        if (!regex.find() && this.containsUppercase) {
            return false;
        }

        Pattern patternThree = Pattern.compile("[0-9]");
        regex = patternThree.matcher(password);

        if (!regex.find() && this.containsDigit) {
            return false;
        }

        Pattern patternFour = Pattern.compile("[!@#$%^&*()_+<>?]");
        regex = patternFour.matcher(password);

        if (!regex.find() && this.containsSpecialSymbol) {
            return false;
        }

        return true;
    }
}
