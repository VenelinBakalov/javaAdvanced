package hell.entities.miscellaneous;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  This is an annotation for a collection, made for the sole purpouse of extracting a private field with reflection
 *  METAAnnotation @Target(ElementType.FIELD) - Target type of the annotation
 *  METAAnnotation @Retention(RetentionPolicty.RUNTIME) - The usage policy of the annotation
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ItemCollection {
}