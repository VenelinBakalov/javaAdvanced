package bg.softuni.provider.type;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public class ClassProvider implements TypeProvider {

    private Class[] classes;

    private Map<Class, Class[]> classesByAnnotation;

    public ClassProvider(Class[] classes) {
        this.classes = classes;
        this.classesByAnnotation = new HashMap<>();
    }

    @Override
    public Class[] getClassesByAnnotation(Class annotation) {
        if (classesByAnnotation.containsKey(annotation)) {
            return this.classesByAnnotation.get(annotation);
        }
        Class[] result = Arrays.stream(this.classes)
                .filter(c -> c.isAnnotationPresent(annotation))
                .toArray(Class[]::new);

        this.classesByAnnotation.put(annotation, result);

        return result;
    }
}
