package infernoInfinity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Venelin on 24.3.2017 г..
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Information {
    String author();
    int revision();
    String description();
    String[] reviewers();
}
