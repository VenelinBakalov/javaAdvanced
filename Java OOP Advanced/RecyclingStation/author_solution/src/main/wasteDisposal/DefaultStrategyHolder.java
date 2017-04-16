package main.wasteDisposal;

import main.wasteDisposal.annotations.Disposable;
import main.wasteDisposal.Contracts.GarbageDisposalStrategy;
import main.wasteDisposal.Contracts.StrategyHolder;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultStrategyHolder implements StrategyHolder {
    private LinkedHashMap<Class,GarbageDisposalStrategy> strategies;

    public DefaultStrategyHolder(){
        this.strategies = new LinkedHashMap<>();
    }

    @Override
    public Map<Class, GarbageDisposalStrategy> getDisposalStrategies() {
        return Collections.unmodifiableMap(this.strategies);
    }

    @Override
    public boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy) {
        if(!annotationClass.isAnnotationPresent(Disposable.class)){
            throw new IllegalArgumentException("The passed in class does not implement @Disposable annotation!");
        }
        if(this.strategies.containsKey(annotationClass)){
            return false;
        }

        this.strategies.put(annotationClass,strategy);
        return true;
    }

    @Override
    public boolean removeStrategy(Class annotationClass) {
        if(!annotationClass.isAnnotationPresent(Disposable.class)){
            throw new IllegalArgumentException("The passed in class does not implement @Disposable annotation!");
        }
        if(!this.strategies.containsKey(annotationClass)){
            return false;
        }
        this.strategies.remove(annotationClass);
        return true;
    }
}
