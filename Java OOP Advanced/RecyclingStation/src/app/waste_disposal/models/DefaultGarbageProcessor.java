package app.waste_disposal.models;

import app.waste_disposal.annotations.Disposable;
import app.waste_disposal.contracts.*;

import java.lang.annotation.Annotation;

public class DefaultGarbageProcessor implements GarbageProcessor {

    private StrategyHolder strategyHolder;

    public DefaultGarbageProcessor(StrategyHolder strategyHolder){
        this.setStrategyHolder(strategyHolder);
    }

    private void setStrategyHolder(StrategyHolder strategyHolder) {
        this.strategyHolder = strategyHolder;
    }

    @Override
    public StrategyHolder getStrategyHolder() {
        return this.strategyHolder;
    }

    @Override
    public ProcessingData processWaste(Waste garbage) {
        Class type = garbage.getClass();
        Annotation[] garbageAnnotations = type.getAnnotations();
        Class disposableAnnotation = null;
        for (Annotation annotation : garbageAnnotations) {
            if(annotation.annotationType().isAnnotationPresent(Disposable.class)){
                disposableAnnotation = annotation.annotationType();
                break;
            }
        }

        GarbageDisposalStrategy currentStrategy;
        if (disposableAnnotation == null || !this.getStrategyHolder().getDisposalStrategies().containsKey(disposableAnnotation))
        {
            throw new IllegalArgumentException(
                    "The passed in garbage does not implement an annotation implementing the Disposable meta-annotation or is not supported by the StrategyHolder.");
        }
        currentStrategy = this.getStrategyHolder().getDisposalStrategies().get(disposableAnnotation);
        return currentStrategy.processGarbage(garbage);
    }
}
