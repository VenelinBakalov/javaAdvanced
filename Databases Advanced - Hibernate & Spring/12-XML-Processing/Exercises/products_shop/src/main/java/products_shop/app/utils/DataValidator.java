package products_shop.app.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class DataValidator {
    public static <T> String  validate(T target){
        ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> validate = factory.getValidator().validate(target);
        if (!validate.isEmpty()){
            for (ConstraintViolation<T> constraint : validate) {
                return constraint.getMessage();
            }
        }
        return null;
    }

}
