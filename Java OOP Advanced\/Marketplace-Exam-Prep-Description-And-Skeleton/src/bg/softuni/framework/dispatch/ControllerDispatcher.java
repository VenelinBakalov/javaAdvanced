package bg.softuni.framework.dispatch;

import bg.softuni.framework.container.Container;
import bg.softuni.framework.lifecycle.component.Component;
import bg.softuni.framework.lifecycle.component.Inject;
import bg.softuni.framework.lifecycle.controller.ControllerActionPair;
import bg.softuni.framework.lifecycle.request.RequestMethod;
import bg.softuni.framework.parser.Parser;
import bg.softuni.framework.parser.strategy.ControllerAnnotationParserStrategy;
import bg.softuni.provider.type.TypeProvider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by Venelin on 9.4.2017 г..
 */
@Component
public class ControllerDispatcher implements Dispatcher {

    @Inject
    private Parser parser;

    @Inject
    private TypeProvider provider;

    @Inject
    private Container container;

    private Map<RequestMethod, Map<String, ControllerActionPair>> controllers;

    private Map<Class, Function<String, Object>> typeConversions;

    public ControllerDispatcher() throws InstantiationException, IllegalAccessException {
        this.controllers = new HashMap<>();
    }

    @Override
    public String dispatch(RequestMethod requestMethod, String uri) throws InvocationTargetException, IllegalAccessException {
        Map<String, ControllerActionPair> innerMap =
                this.controllers.get(requestMethod);

        for (String regex : innerMap.keySet()) {
            if (uri.matches(regex)) {
                ControllerActionPair pair = innerMap.get(regex);
                Object controller = pair.getController();
                Method methodToInvoke = pair.getAction();
                Map<Integer, Class> argumentsByPosition = pair.getArgumentsMapping();

                String uriTokens[] = uri.split("\\/");

                Object[] argumentsToPass = new Object[argumentsByPosition.size()];
                int index = 0;
                for (Map.Entry<Integer, Class> typeMapping : argumentsByPosition.entrySet()) {
                    String valueToParse = uriTokens[typeMapping.getKey()];
                    Class classToParseFrom = typeMapping.getValue();
                    argumentsToPass[index++] = this.typeConversions.get(classToParseFrom).apply(valueToParse);

                }

                String result = (String) methodToInvoke.invoke(controller, argumentsToPass);

                return result;
            }
        }

        return null;
    }

    private void fillControllers() throws IllegalAccessException, InstantiationException {
        this.parser.parse(
                new ControllerAnnotationParserStrategy(this.provider),
                this.controllers
        );
    }

    private void createDependencyGraph() {
        this.controllers.values().stream()
                .flatMap(c -> c.values().stream())
                .forEach(this::resolveControllerDependency);
    }

    private void resolveControllerDependency(ControllerActionPair pair) {
        try {
            this.container.resolveDependencies(pair.getController());
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private void fillTypeConversions() {
        this.typeConversions = new HashMap<Class, Function<String, Object>>() {{
            put(String.class, s -> s);
            put(Integer.class, Integer::parseInt);
            put(int.class, Integer::parseInt);
            put(Double.class, Double::parseDouble);
            put(double.class, Double::parseDouble);
            put(Long.class, Long::parseLong);
            put(long.class, Long::parseLong);
        }};
    }

    private void initialize() throws InstantiationException, IllegalAccessException {
        this.fillTypeConversions();
        this.fillControllers();
        this.createDependencyGraph();
    }
}
