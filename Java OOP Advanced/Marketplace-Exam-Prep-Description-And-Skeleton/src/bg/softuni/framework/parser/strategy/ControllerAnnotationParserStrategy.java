package bg.softuni.framework.parser.strategy;

import bg.softuni.framework.lifecycle.RequestMapping;
import bg.softuni.framework.lifecycle.component.Component;
import bg.softuni.framework.lifecycle.controller.Controller;
import bg.softuni.framework.lifecycle.controller.ControllerActionPair;
import bg.softuni.framework.lifecycle.controller.UriParameter;
import bg.softuni.framework.lifecycle.request.RequestMethod;
import bg.softuni.provider.type.TypeProvider;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public class ControllerAnnotationParserStrategy implements AnnotationParserStrategy<RequestMethod, Map<String, ControllerActionPair>> {

    private TypeProvider provider;

    public ControllerAnnotationParserStrategy(TypeProvider provider) {
        this.provider = provider;
    }

    @Override
    public void parse(Map<RequestMethod, Map<String, ControllerActionPair>> cachedResult) throws IllegalAccessException, InstantiationException {
        for (Class currentClass : this.provider.getClassesByAnnotation(Controller.class)) {
            for (Method currentMethod : currentClass.getDeclaredMethods()) {
                if (currentMethod.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping requestMapping
                            = currentMethod.getAnnotation(RequestMapping.class);

                    RequestMethod requestMethod = requestMapping.method();
                    String mapping = requestMapping.value();
                    List<String> mappingTokens = Arrays.stream(mapping.split("\\/"))
                            .collect(Collectors.toList());
                    Map<Integer, Class> argumentsMapping = new HashMap<>();

                    mapping = this.createMappingRegex(currentMethod, mapping, mappingTokens, argumentsMapping);

                    Object controllerInstance = currentClass.newInstance();

                    ControllerActionPair pair = new ControllerActionPair(controllerInstance, currentMethod, argumentsMapping);

                    if (!cachedResult.containsKey(requestMethod)) {
                        cachedResult.put(requestMethod, new HashMap<>());
                    }

                    cachedResult.get(requestMethod).put(mapping, pair);
                }
            }
        }


    }

    private String createMappingRegex(Method currentMethod, String mapping, List<String> mappingTokens, Map<Integer, Class> argumentsMapping) {
        for (int i = 0; i < mappingTokens.size(); i++) {
            if (!(mappingTokens.get(i).startsWith("{") && mappingTokens.get(i).endsWith("}"))) {
                continue;
            }
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
        return mapping;
    }
}
