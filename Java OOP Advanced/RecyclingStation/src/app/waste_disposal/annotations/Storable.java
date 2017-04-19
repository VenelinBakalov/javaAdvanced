package app.waste_disposal.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Venelin on 19.4.2017 г..
 */
@Disposable
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Storable {
}
