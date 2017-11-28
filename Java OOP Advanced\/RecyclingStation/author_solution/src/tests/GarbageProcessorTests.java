package tests;


import main.wasteDisposal.Contracts.*;
import main.wasteDisposal.DefaultGarbageProcessor;
import org.junit.Before;
import static org.mockito.Mockito.*;
import org.junit.Assert;

import org.junit.Test;
import org.junit.internal.runners.TestMethod;
import org.mockito.Mockito;
import tests.mockedObjects.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class GarbageProcessorTests {

    private GarbageProcessor garbageProcessor;
    private StrategyHolder mockedStrategyHolder;

    private GarbageDisposalStrategy mockedStrategy;
    private GarbageDisposalStrategy mockedStrategy2;

    private Class mockedDisposableAnnotation;
    private Class mockedDisposableAnnotation2;
    private Class nonAnnotationClass;

    private ProcessingData mockedProcessingData;
    private ProcessingData mockedProcessingData2;

    @Before
    public void initialize(){
        this.mockedStrategyHolder = Mockito.mock(StrategyHolder.class);
        Map<Class,GarbageDisposalStrategy> strategies = new LinkedHashMap<>();

        this.mockedStrategy= Mockito.mock(GarbageDisposalStrategy.class);
        this.mockedStrategy2 = Mockito.mock(GarbageDisposalStrategy.class);
        this.mockedDisposableAnnotation = MockedDisposalAnnotation.class;
        this.mockedDisposableAnnotation2 = MockedDisposalAnnotation2.class;
        this.nonAnnotationClass = NonAnnotationObject.class;

        this.mockedProcessingData = Mockito.mock(ProcessingData.class);
        this.mockedProcessingData2 = Mockito.mock(ProcessingData.class);

        when(this.mockedStrategy.ProcessGarbage(isA(Waste.class))).thenReturn(this.mockedProcessingData);
        when(this.mockedStrategy2.ProcessGarbage(isA(Waste.class))).thenReturn(this.mockedProcessingData2);

        strategies.put(this.mockedDisposableAnnotation, this.mockedStrategy);
        strategies.put(this.mockedDisposableAnnotation2, this.mockedStrategy2);

        when(this.mockedStrategyHolder.getDisposalStrategies()).thenReturn(strategies);
        this.garbageProcessor = new DefaultGarbageProcessor(this.mockedStrategyHolder);
    }

    @Test
    public void getStrategyHolder_WithAPassedInStrategyHolderInTheConstructor_ShouldReturnSameStrategyHolder()
    {
        Assert.assertEquals("The method did not return the expected object!", this.mockedStrategyHolder, this.garbageProcessor.getStrategyHolder());
    }

    @Test(expected = IllegalArgumentException.class)
    public void processWaste_WithAWasteObjectThatDoesNotContainAnnotationWithADisposableMetaAnnotation_ShouldThrowAnIllegalArgumentException()
    {
        Waste fakeWaste = Mockito.mock(Waste.class);
        this.garbageProcessor.processWaste(fakeWaste);
    }

    @Test(expected = IllegalArgumentException.class)
    public void processWaste_WithAWasteObjectWhoseAnnotationIsNotPresentInTheStrategyHolder_ShouldThrowAnIllegalArgumentException()
    {
        Waste fakeWaste = new MockedWasteWithNonPresentAnnotation();

        this.garbageProcessor.processWaste(fakeWaste);
    }

    @Test
    public void processWaste_WithACorrectWasteObject_ShouldCallCorrectStrategy()
    {
        Waste fakeWaste = new MockedWasteWithPresentAnnotation();
        this.garbageProcessor.processWaste(fakeWaste);

        verify(this.mockedStrategy, times(1)).ProcessGarbage(isA(Waste.class));
    }

    @Test
    public void processWaste_WithACorrectWasteObject_ShouldCallCorrectStrategyWithCorrectWaste()
    {
        Waste fakeWaste = new MockedWasteWithPresentAnnotation();
        this.garbageProcessor.processWaste(fakeWaste);

        verify(this.mockedStrategy, times(1)).ProcessGarbage(fakeWaste);
    }

    @Test
    public void processWaste_WithACorrectWasteObject_ShouldReturnCorrectProcessDataObject()
    {
        Waste fakeWaste = new MockedWasteWithPresentAnnotation();
        ProcessingData result = this.garbageProcessor.processWaste(fakeWaste);

        Assert.assertEquals("Expected object did not match!",this.mockedProcessingData,result);
    }
}
