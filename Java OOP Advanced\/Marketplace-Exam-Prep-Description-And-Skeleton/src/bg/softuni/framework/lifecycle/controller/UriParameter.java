package bg.softuni.framework.lifecycle.controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface UriParameter {

    String value();

}
