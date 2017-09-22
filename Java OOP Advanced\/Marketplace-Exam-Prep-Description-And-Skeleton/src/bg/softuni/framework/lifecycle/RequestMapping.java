package bg.softuni.framework.lifecycle;

import bg.softuni.framework.lifecycle.request.RequestMethod;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    String value();

    RequestMethod method() default RequestMethod.ADD;
}
