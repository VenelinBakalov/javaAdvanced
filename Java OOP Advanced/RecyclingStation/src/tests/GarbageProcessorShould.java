package tests;

import tests.fakes.DisposableAnnotation;
import tests.fakes.DisposableWaste;
import tests.fakes.NonAnnotatedWaste;
import tests.fakes.NonDisposableWaste;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.StrategyHolder;
import app.waste_disposal.models.DefaultGarbageProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public class GarbageProcessorShould {

    private final Map<Class, GarbageDisposalStrategy> strategies = new LinkedHashMap<>();

    private DefaultGarbageProcessor garbageProcessor;
    private StrategyHolder strategyHolderMock;
    private ProcessingData processingDataMock;
    private GarbageDisposalStrategy garbageDisposalStrategyMock;

    @Before
    public void initialize() {
        this.strategyHolderMock = Mockito.mock(StrategyHolder.class);
        this.garbageDisposalStrategyMock = Mockito.mock(GarbageDisposalStrategy.class);
        this.garbageProcessor = new DefaultGarbageProcessor(strategyHolderMock);
        this.processingDataMock = Mockito.mock(ProcessingData.class);
        this.strategies.put(DisposableAnnotation.class, this.garbageDisposalStrategyMock);
    }

    @Test
    public void returnStrategyHolderIfPresent() {
        Assert.assertEquals(this.strategyHolderMock, this.garbageProcessor.getStrategyHolder());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenNullStrategyHolderIsPassed() {
        this.garbageProcessor = new DefaultGarbageProcessor(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenNonDisposableWasteIsProcessed() {
        this.garbageProcessor.processWaste(new NonDisposableWaste());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenNonAnnotatedWasteIsProcessed() {
        this.garbageProcessor.processWaste(new NonAnnotatedWaste());
    }

    @Test()
    public void returnProcessingDataIfDisposableWastePassed() {
        //arrange
        Mockito.when(this.garbageDisposalStrategyMock.processGarbage(Mockito.isA(DisposableWaste.class))).thenReturn(this.processingDataMock);
        Mockito.when(this.strategyHolderMock.getDisposalStrategies()).thenReturn(this.strategies);

        //act
        ProcessingData result = this.garbageProcessor.processWaste(new DisposableWaste());

        //assert
        Assert.assertSame(this.processingDataMock, result);
    }
}
