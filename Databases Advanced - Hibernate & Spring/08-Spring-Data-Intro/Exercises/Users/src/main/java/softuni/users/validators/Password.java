package softuni.users.validators;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Venelin on 25.7.2017 г..
 */
@Component
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

    String message() default "Invalid password format";
    int minLength() default 6;
    int maxLength() default 30;
    boolean containsDigit() default false;
    boolean containsLowercase() default false;
    boolean containsUppercase() default false;
    boolean containsSpecialSymbol() default false;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
