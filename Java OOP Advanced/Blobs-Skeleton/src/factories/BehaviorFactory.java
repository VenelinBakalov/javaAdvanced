package factories;

import interfaces.Behavior;

/**
 * Created by Venelin on 8.4.2017 г..
 */
public class BehaviorFactory {
    private static final String BEHAVIORS_PACKAGE = "models.behaviors.";

    public Behavior createBehavior(String behaviorType) throws ReflectiveOperationException {
        Class<Behavior> behaviorClass = (Class<Behavior>) Class.forName(BEHAVIORS_PACKAGE + behaviorType);
        return behaviorClass.newInstance();
    }
}
