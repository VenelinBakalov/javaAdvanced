package bg.softuni.framework.lifecycle.controller;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author RoYaL
 */
public final class ControllerActionPair {
    private final Method action;

    /**
     * The controller object with all of its
     * dependencies bundled
     */
    private final Object controller;
    /**
     * Association by position in the input string
     *    e.g.: /users/{4}/edit/{gosho}
     *    Arguments are on indices 2 and 4
     */
    private Map<Integer, Class> argumentsMapping;

    public ControllerActionPair(final Object controller, final Method action, final Map<Integer, Class> argumentsMapping) {
        this.controller = controller;
        this.action = action;
        this.argumentsMapping = argumentsMapping;
    }

    public Method getAction() {
        return action;
    }

    public Object getController() {
        return controller;
    }

    public Map<Integer, Class> getArgumentsMapping() {
        return this.argumentsMapping;
    }
}
