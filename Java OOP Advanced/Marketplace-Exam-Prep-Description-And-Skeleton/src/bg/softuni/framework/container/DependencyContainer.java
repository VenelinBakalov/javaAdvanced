package bg.softuni.framework.container;

import bg.softuni.framework.lifecycle.component.Inject;
import bg.softuni.framework.parser.Parser;
import bg.softuni.framework.parser.strategy.ComponentAnnotationParsesStrategy;
import bg.softuni.provider.type.TypeProvider;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public class DependencyContainer implements Container {
    private static final String INITIALIZE_METHOD = "initialize";

    private Parser parser;

    private TypeProvider provider;

    private Map<Class, Class> components;

    private Map<Class, Object> cachedComponents;

    public DependencyContainer(Parser parser, TypeProvider provider) throws InstantiationException, IllegalAccessException {
        this.parser = parser;
        this.components = new HashMap<>();
        this.cachedComponents = new HashMap<>();
        this.provider = provider;
        this.fillComponents();
    }

    @Override
    public <T> T resolve(Class<T> from) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (!this.components.containsKey(from)) {
            throw new UnsupportedOperationException(
                    "Cannot map dependency of type "
                            + from.getName()
                            + ". It is not annotated with @Component " +
                            "or not registered in bg.softuni.Main.@ComponentScan"
            );
        }

        T result = (T)this.components.get(from).newInstance();

        this.resolveDependencies(result);

        Optional<Method> initMethod = Arrays.stream(result.getClass().getDeclaredMethods())
                .filter(m -> m.getName().equals(INITIALIZE_METHOD))
                .findFirst();

        if (initMethod.isPresent()) {
            Method method = initMethod.get();
            method.setAccessible(true);
            method.invoke(result);
        }

        return result;
    }

    public void resolveDependencies(Object object) throws IllegalAccessException, InstantiationException {
        Field[] currentDependencies = Arrays.stream(object
                .getClass()
                .getDeclaredFields())
                .filter(t -> t.isAnnotationPresent(Inject.class))
                .toArray(Field[]::new);

        for (Field dependency : currentDependencies) {
            dependency.setAccessible(true);
            Class currentDependencySource = dependency.getType();

            if (!this.components.containsKey(currentDependencySource)) {
                throw new UnsupportedOperationException(
                        "Cannot map dependency of type "
                                + currentDependencySource.getName()
                                + ". It is not annotated with @Component " +
                                "or not registered in bg.softuni.Main.@ComponentScan"
                );
            }

            Class currentDependencyTarget = this.components.get(currentDependencySource);


            Object currentDependencyInstance
                    = currentDependencyTarget.newInstance();
            dependency.set(object, currentDependencyInstance);

            this.resolveDependencies(currentDependencyInstance);
        }
    }

    public void addDependency(Class from, Object to) {
        this.cachedComponents.put(to.getClass(), to);
        this.components.put(from, to.getClass());
    }


    private void fillComponents() throws IllegalAccessException, InstantiationException {
        this.parser.parse(
                new ComponentAnnotationParsesStrategy(this.provider),
                this.components
        );
    }
}
