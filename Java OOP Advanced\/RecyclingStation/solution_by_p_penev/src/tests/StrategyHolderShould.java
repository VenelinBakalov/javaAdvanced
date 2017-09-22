package tests;

import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tests.fakes.DisposableAnnotation;
import tests.fakes.NonDisposableAnnotation;

import java.util.Map;

public class StrategyHolderShould {

    private StrategyHolder strategyHolder;

    private GarbageDisposalStrategy mockedStrategy;
    private Class disposableAnnotationClass;
    private Class nonDisposableAnnotationClass;

    @Before
    public void initialize() {
        this.strategyHolder = new DefaultStrategyHolder();
        this.mockedStrategy= Mockito.mock(GarbageDisposalStrategy.class);
        this.disposableAnnotationClass = DisposableAnnotation.class;
        this.nonDisposableAnnotationClass = NonDisposableAnnotation.class;
    }

    @Test
    public void returnEmptyCollectionAfterInitialization() {
        Map<Class,GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
        Assert.assertEquals("Operation returned incorrect result!", 0, strategies.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void returnAReadOnlyCollection() {
        Map<Class,GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
        strategies.put(this.disposableAnnotationClass,this.mockedStrategy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwIfPassedNonDisposableAnnotation() {
        this.strategyHolder.addStrategy(this.nonDisposableAnnotationClass, this.mockedStrategy);
    }

    @Test
    public void returnFalseWhenPassedExistingStrategy() {
        this.strategyHolder.addStrategy(this.disposableAnnotationClass, this.mockedStrategy);
        boolean result = this.strategyHolder.addStrategy(this.disposableAnnotationClass, this.mockedStrategy);

        Assert.assertEquals("Operation returned incorrect result!",false, result);
    }

    @Test
    public void addStrategy_WithCorrectNonExistingValues_ShouldAddStrategyToCollection()
    {
        Map<Class,GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
        Assert.assertEquals("Strategies count did not match!", 0, strategies.size());

        this.strategyHolder.addStrategy(this.disposableAnnotationClass, this.mockedStrategy);

        Assert.assertEquals("Strategies count did not match!",1, strategies.size());
    }

    @Test
    public void addStrategy_WithCorrectNonExistingValues_ShouldAddCorrectStrategy()
    {
        Map<Class,GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();

        this.strategyHolder.addStrategy(this.disposableAnnotationClass, this.mockedStrategy);

        GarbageDisposalStrategy result = strategies.get(this.disposableAnnotationClass);
        GarbageDisposalStrategy expected = this.mockedStrategy;
        Assert.assertEquals("Expected strategy did not match!", expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenRemovingNonDisposable() {
        this.strategyHolder.removeStrategy(this.nonDisposableAnnotationClass);
    }

    @Test
    public void shouldReturnFalseWhenRemovingFromEmptyHolder() {
        boolean result = this.strategyHolder.removeStrategy(this.disposableAnnotationClass);

        Assert.assertEquals("Operation returned incorrect result!", false, result);
    }
}
