package soft.uni.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Venelin on 28.7.2017 г..
 */
@Component
public class DoublePrecisionValidator implements ConstraintValidator<DoublePrecision, Double> {

    private boolean isPositive;
    private int precisionAfterFloatingPoint;

    @Override
    public void initialize(DoublePrecision doublePrecision) {
        this.isPositive = doublePrecision.isPositive();
        this.precisionAfterFloatingPoint = doublePrecision.precisionAfterFloatingPoint();
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext constraintValidatorContext) {

        if (this.isPositive && value < 0) {
            return false;
        }

        String[] integerAndFraction = value.toString().split("\\.");

        if (integerAndFraction.length == 1) return true;

        String fraction = integerAndFraction[1];

        if (fraction.length() > this.precisionAfterFloatingPoint) {
            return false;
        }

        return true;
    }
}
