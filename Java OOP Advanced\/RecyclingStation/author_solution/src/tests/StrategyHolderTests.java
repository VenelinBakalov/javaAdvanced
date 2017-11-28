package tests;

import main.wasteDisposal.Contracts.GarbageDisposalStrategy;
import main.wasteDisposal.Contracts.StrategyHolder;
import main.wasteDisposal.DefaultStrategyHolder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tests.mockedObjects.MockedDisposalAnnotation;
import tests.mockedObjects.MockedDisposalAnnotation2;
import tests.mockedObjects.NonAnnotationObject;

import java.util.Map;

public class StrategyHolderTests {

    private StrategyHolder strategyHolder;

    private GarbageDisposalStrategy mockedStrategy;
    private GarbageDisposalStrategy mockedStrategy2;

    private Class mockedDisposableAnnotation;
    private Class mockedDisposableAnnotation2;
    private Class nonAnnotationClass;

    @Before
    public void initialize(){
        this.strategyHolder = new DefaultStrategyHolder();
        this.mockedStrategy= Mockito.mock(GarbageDisposalStrategy.class);
        this.mockedStrategy2 = Mockito.mock(GarbageDisposalStrategy.class);
        this.mockedDisposableAnnotation = MockedDisposalAnnotation.class;
        this.mockedDisposableAnnotation2 = MockedDisposalAnnotation2.class;
        this.nonAnnotationClass = NonAnnotationObject.class;
    }

    @Test
    public void getDisposalStrategies_WithANewInstance_ShouldReturnAnEmptyCollection()
    {
        Map<Class,GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
        Assert.assertEquals("Operation returned incorrect result!", 0, strategies.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getDisposalStrategies_ShouldReturnAReadOnlyCollection()
    {
        Map<Class,GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
        strategies.put(this.mockedDisposableAnnotation,this.mockedStrategy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStrategy_WithATypeThatDoesNotContainDisposableMetaAnnotation_ShouldThrowIllegalArgumentException()
    {
        this.strategyHolder.addStrategy(this.nonAnnotationClass, this.mockedStrategy);
    }

    @Test
    public void addStrategy_WithAnAlreadyExistingAnnotationClass_ShouldReturnFalse()
    {
        this.strategyHolder.addStrategy(this.mockedDisposableAnnotation, this.mockedStrategy);
        boolean result = this.strategyHolder.addStrategy(this.mockedDisposableAnnotation, this.mockedStrategy);

        Assert.assertEquals("Operation returned incorrect result!",false, result);
    }

    @Test
    public void addStrategy_WithAnAlreadyExistingAnnotationClass_ShouldNotAddItToTheExistingStrategies()
    {
        this.strategyHolder.addStrategy(this.mockedDisposableAnnotation, this.mockedStrategy);
        boolean result = this.strategyHolder.addStrategy(this.mockedDisposableAnnotation, this.mockedStrategy);

        Map<Class,GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
        Assert.assertEquals("Strategies count did not match!",1, strategies.size());
    }

    @Test
    public void addStrategy_WithCorrectNonExistingValues_ShouldAddStrategyToCollection()
    {
        Map<Class,GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
        Assert.assertEquals("Strategies count did not match!", 0, strategies.size());

        this.strategyHolder.addStrategy(this.mockedDisposableAnnotation, this.mockedStrategy);

        Assert.assertEquals("Strategies count did not match!",1, strategies.size());
    }

    @Test
    public void addStrategy_WithCorrectNonExistingValues_ShouldAddCorrectStrategy()
    {
        Map<Class,GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();

        this.strategyHolder.addStrategy(this.mockedDisposableAnnotation, this.mockedStrategy);

        GarbageDisposalStrategy result = strategies.get(this.mockedDisposableAnnotation);
        GarbageDisposalStrategy expected = this.mockedStrategy;
        Assert.assertEquals("Expected strategy did not match!", expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeStrategy_WithATypeThatDoesNotContainDisposableMetaAnnotation_ShouldThrowIllegalArgumentException()
    {
        this.strategyHolder.removeStrategy(this.nonAnnotationClass);
    }

    @Test
    public void removeStrategy_WithAnNonExistingAnnotationClass_ShouldReturnFalse()
    {
        boolean result = this.strategyHolder.removeStrategy(this.mockedDisposableAnnotation);

        Assert.assertEquals("Operation returned incorrect result!",false, result);
    }

    @Test
    public void removeStrategy_WithAnNonExistingAnnotationClass_ShouldNotRemoveItemsFromTheCollection()
    {
        this.strategyHolder.addStrategy(this.mockedDisposableAnnotation, this.mockedStrategy);

        Map<Class,GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
        Assert.assertEquals("Strategies count did not match!",1, strategies.size());

        this.strategyHolder.removeStrategy(this.mockedDisposableAnnotation2);

        Assert.assertEquals("Strategies count did not match!",1, strategies.size());
    }

    @Test
    public void removeStrategy_WithCorrectExistingAnnotationClass_ShouldRemoveEntryFromTheCollection()
    {
        this.strategyHolder.addStrategy(this.mockedDisposableAnnotation, this.mockedStrategy);
        this.strategyHolder.addStrategy(this.mockedDisposableAnnotation2, this.mockedStrategy2);

        Map<Class,GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
        Assert.assertEquals("Strategies count did not match!",2, strategies.size());

        this.strategyHolder.removeStrategy(this.mockedDisposableAnnotation);

        Assert.assertEquals("Strategies count did not match!",1, strategies.size());
    }

    @Test
    public void removeStrategy_WithCorrectExistingValueWithMultipleEntries_ShouldRemoveCorrectEntry()
    {
        this.strategyHolder.addStrategy(this.mockedDisposableAnnotation, this.mockedStrategy);
        this.strategyHolder.addStrategy(this.mockedDisposableAnnotation2, this.mockedStrategy2);

        Map<Class,GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();

        this.strategyHolder.removeStrategy(this.mockedDisposableAnnotation);

        GarbageDisposalStrategy strategy = strategies.get(this.mockedDisposableAnnotation);
        Assert.assertNull("Expected null, but received a correct instance",strategy);
    }
}
