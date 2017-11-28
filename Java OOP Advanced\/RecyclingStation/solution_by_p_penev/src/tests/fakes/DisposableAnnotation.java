package tests.fakes;

import app.waste_disposal.annotations.Disposable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Disposable
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DisposableAnnotation {

}
