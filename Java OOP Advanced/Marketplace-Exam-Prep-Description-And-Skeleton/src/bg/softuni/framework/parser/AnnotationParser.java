package bg.softuni.framework.parser;

import bg.softuni.Main;
import bg.softuni.framework.lifecycle.ComponentScan;
import bg.softuni.framework.lifecycle.RequestMapping;
import bg.softuni.framework.lifecycle.component.Component;
import bg.softuni.framework.lifecycle.component.Inject;
import bg.softuni.framework.lifecycle.controller.Controller;
import bg.softuni.framework.lifecycle.controller.ControllerActionPair;
import bg.softuni.framework.lifecycle.controller.UriParameter;
import bg.softuni.framework.lifecycle.request.RequestMethod;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author RoYaL
 */
public class AnnotationParser implements Parser {

    private ClassLoader classLoader;

    /**
     * Association of Request Method => URI => Controller.Action()
     * e.g. "GET" => "/users/6" => {"UsersController", "Get(id)"}
     */
    private Map<RequestMethod, Map<String, ControllerActionPair>> controllers;

    /**
     * A component is any bean that can be injected by any resolver
     * The association kept here is:
     *     "Abstraction" => "Implementation"
     */
    private Map<Class, Class> components;

    public AnnotationParser(ClassLoader classLoader) {
        Main.class.getAnnotation(ComponentScan.class).classes();
        this.classLoader = classLoader;
        this.controllers = new HashMap<>();
        this.components = new HashMap<>();
    }

    @Override
    public void parse() {
        try {
            Iterator<Class> iterator = this.getDeclaredClasses();
            List<Class> classes = new ArrayList<>();
            while (iterator.hasNext()) {
                classes.add(iterator.next());
            }
            for (Class currentClass : classes) {
                if (currentClass.isAnnotationPresent(Controller.class)) {
                    for (Method currentMethod : currentClass.getDeclaredMethods()) {
                        if (currentMethod.isAnnotationPresent(RequestMapping.class)) {
                            RequestMapping requestMapping
                                    = currentMethod.getAnnotation(RequestMapping.class);

                            RequestMethod requestMethod = requestMapping.method();
                            String mapping = requestMapping.value();
                            List<String> mappingTokens = Arrays.stream(mapping.split("\\/"))
                                    .collect(Collectors.toList());
                            Map<Integer, Class> argumentsMapping = new HashMap<>();

                            for (int i = 0; i < mappingTokens.size(); i++) {
                                if (mappingTokens.get(i).startsWith("{") && mappingTokens.get(i).endsWith("}")) {
                                    for (Parameter param : currentMethod.getParameters()) {
                                        if (!param.isAnnotationPresent(UriParameter.class)) {
                                            continue;
                                        }
                                        UriParameter uriParameter = param.getAnnotation(UriParameter.class);
                                        if (mappingTokens.get(i).equals("{" + uriParameter.value() + "}")) {
                                            argumentsMapping.put(
                                                    i,
                                                    param.getType()
                                            );

                                            mapping = mapping.replace(mappingTokens.get(i), param.getType() == String.class ? "\\w+" : "\\d+");
                                            break;
                                        }
                                    }
                                }
                            }

                            Object controllerInstance = currentClass.newInstance();

                            ControllerActionPair pair = new ControllerActionPair(controllerInstance, currentMethod, argumentsMapping);

                            if (!this.controllers.containsKey(requestMethod)) {
                                this.controllers.put(requestMethod, new HashMap<>());
                            }

                            this.controllers.get(requestMethod).put(mapping, pair);
                        }
                    }
                } else if (currentClass.isAnnotationPresent(Component.class)) {
                    for (Class parent : currentClass.getInterfaces()) {
                        this.components.put(parent, currentClass);
                    }
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        this.controllers.values().stream().flatMap(c -> c.values().stream()).forEach(c -> {
            try {
                this.resolveDependencies(c.getController());
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        });


    }

    public Map<RequestMethod, Map<String, ControllerActionPair>> getControllers() {
        return this.controllers;
    }

    public Map<Class, Class> getComponents() {
        return this.components;
    }

    public <T> T resolve(Class<T> from) throws IllegalAccessException, InstantiationException {
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

        return result;
    }

    private void resolveDependencies(Object object) throws IllegalAccessException, InstantiationException {
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

    private Iterator<Class> getDeclaredClasses()
            throws NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {
        Class classLoaderClass = this.classLoader.getClass();
        while (classLoaderClass != ClassLoader.class) {
            classLoaderClass = classLoaderClass.getSuperclass();
        }

        Field classesField
                = classLoaderClass.getDeclaredField("classes");
        classesField.setAccessible(true);

        Vector classes = (Vector)classesField.get(this.classLoader);

        return classes.iterator();
    }
}

