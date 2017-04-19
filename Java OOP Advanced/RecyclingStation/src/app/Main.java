package app;

import app.waste_disposal.annotations.Burnable;
import app.waste_disposal.annotations.Recyclable;
import app.waste_disposal.annotations.Storable;
import app.waste_disposal.contracts.*;
import app.waste_disposal.engines.Engine;
import app.waste_disposal.factories.GarbageFactoryImpl;
import app.waste_disposal.interpreters.CommandInterpreter;
import app.waste_disposal.io.ConsoleReader;
import app.waste_disposal.io.ConsoleWriter;
import app.waste_disposal.io.Reader;
import app.waste_disposal.io.Writer;
import app.waste_disposal.models.DefaultGarbageProcessor;
import app.waste_disposal.models.DefaultStrategyHolder;
import app.waste_disposal.models.RecyclingStationImpl;
import app.waste_disposal.models.strategies.BurnableGarbageDisposalStrategy;
import app.waste_disposal.models.strategies.RecyclableGarbageDisposalStrategy;
import app.waste_disposal.models.strategies.StorableGarbageDisposalStrategy;;

public class Main {
    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        StrategyHolder strategyHolder = new DefaultStrategyHolder();
        strategyHolder.addStrategy(Burnable.class, new BurnableGarbageDisposalStrategy());
        strategyHolder.addStrategy(Recyclable.class, new RecyclableGarbageDisposalStrategy());
        strategyHolder.addStrategy(Storable.class, new StorableGarbageDisposalStrategy());

        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor(strategyHolder);
        GarbageFactory garbageFactory = new GarbageFactoryImpl();
        RecyclingStation station = new RecyclingStationImpl();

        Interpreter interpreter = new CommandInterpreter(garbageProcessor, garbageFactory, station);

        Runnable engine = new Engine(reader, writer, interpreter);

        engine.run();
    }
}
