package app.waste_disposal.contracts;

import java.util.Map;

/**
 * Interface that exposes the framework's Garbage Processor's members. StrategyCollectors passed to the framework should implement this
 * interface.
 */
public interface StrategyHolder {

    /**
     * A getter method that returns a readonly Map containing the currently mapped classes
     * and their corresponding Garbage Disposal Strategies.
     * @return A readonly Map of the currently mapped classes and their strategies.
     */
    Map<Class,GarbageDisposalStrategy> getDisposalStrategies();

    /**
     * A method for adding a new Annotation class and corresponding strategy to the currently contained disposal strategies. annotationClass
     * should be a class of type annotation, implementing the Framework's Disposable meta-annotation.
     * annotationClass should be unique, attempting to add the same class 2 times will result in failure and the method will return false.
     * @param annotationClass An annotation class that implements the Framework's Disposable meta-annotation.
     * @param strategy The corresponding Garbage Disposal Strategy that will be mapped to the annotationClass in case of success.
     * @return True in case the adding was successful and false in case of failure(ex. the passed Class is already contained).
     */
    boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy);

    /**
     * A method for removing an existing Annotation class and its corresponding strategy. annotationClass
     * should be a class of type annotation, implementing the Framework's Disposable meta-annotation.
     * @param annotationClass An annotation class that implements the Framework's Disposable meta-annotation.
     * @return True in case the removal was successful and false in case of failure(ex. the passed Class was not contained in the map).
     */
    boolean removeStrategy(Class annotationClass);
}
