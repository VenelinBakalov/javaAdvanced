package soft.uni.validators;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Venelin on 28.7.2017 г..
 */
@Component
@Constraint(validatedBy = DoublePrecisionValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DoublePrecision {

    String message() default "Double field is not of valid precision. Check constraints";
    boolean isPositive() default false;
    int precisionAfterFloatingPoint() default 0;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
