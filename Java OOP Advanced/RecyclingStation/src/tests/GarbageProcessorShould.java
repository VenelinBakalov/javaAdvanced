package tests;

import app.waste_disposal.contracts.StrategyHolder;
import app.waste_disposal.models.DefaultGarbageProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public class GarbageProcessorShould {

    private DefaultGarbageProcessor garbageProcessor;
    private StrategyHolder strategyHolderMock;

    @Before
    public void initialize() {
        this.strategyHolderMock = Mockito.mock(StrategyHolder.class);
        this.garbageProcessor = new DefaultGarbageProcessor(strategyHolderMock);

    }

    @Test
    public void returnStrategyHolderIfPresent() {
        Assert.assertEquals(this.strategyHolderMock, this.garbageProcessor.getStrategyHolder());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenNullStrategyHolderIsPassed() {
        this.garbageProcessor = new DefaultGarbageProcessor(null);
    }
}
