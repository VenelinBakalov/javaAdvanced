package app;

import app.waste_disposal.contracts.*;
import app.waste_disposal.engines.Engine;
import app.waste_disposal.factories.Factory;
import app.waste_disposal.factories.GarbageFactoryImpl;
import app.waste_disposal.interpreters.CommandInterpreter;
import app.waste_disposal.io.ConsoleReader;
import app.waste_disposal.io.ConsoleWriter;
import app.waste_disposal.io.Reader;
import app.waste_disposal.io.Writer;
import app.waste_disposal.models.DefaultGarbageProcessor;
import app.waste_disposal.models.DefaultStrategyHolder;
import app.waste_disposal.models.recyclingStation.RecyclingStationImpl;
import app.waste_disposal.models.recyclingStation.RecyclingStation;

public class Main {
    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        StrategyHolder strategyHolder = new DefaultStrategyHolder();

        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor(strategyHolder);
        Factory garbageFactory = new GarbageFactoryImpl();
        RecyclingStation station = new RecyclingStationImpl();

        Interpreter interpreter = new CommandInterpreter(garbageProcessor, garbageFactory, station);

        Runnable engine = new Engine(reader, writer, interpreter);

        engine.run();

    }
}
