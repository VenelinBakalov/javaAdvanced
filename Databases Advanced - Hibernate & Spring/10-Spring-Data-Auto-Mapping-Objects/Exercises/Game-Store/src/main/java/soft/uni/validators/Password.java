package soft.uni.validators;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Venelin on 27.7.2017 г..
 */
@Component
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

    String message() default "Invalid password. Min length: 6. Must contain uppercase, lowercase letter and digit.";
    int minLength() default 6;
    boolean containsLowercase() default true;
    boolean containsUppercase() default true;
    boolean containsDigit() default true;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
