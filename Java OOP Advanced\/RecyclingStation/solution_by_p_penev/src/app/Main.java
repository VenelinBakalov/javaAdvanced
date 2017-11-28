package app;

import app.core.BalanceManager;
import app.core.BalanceManagerImpl;
import app.core.Engine;
import app.factories.Factory;
import app.factories.StrategyFactory;
import app.factories.WasteFactory;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;
import app.io.Reader;
import app.io.Writer;
import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.Waste;

public class Main {
    public static void main(String[] args) {
        Reader reader =
                new ConsoleReader();

        Writer writer =
                new ConsoleWriter();

        GarbageProcessor garbageProcessor =
                new DefaultGarbageProcessor();

        BalanceManager balanceManager =
                new BalanceManagerImpl();

        Factory<Waste> wasteFactory =
                new WasteFactory("app.models.wastes.");

        Factory<GarbageDisposalStrategy> strategyFactory =
                new StrategyFactory("app.models.strategies.");

        Engine engine = new Engine(reader, writer, garbageProcessor, balanceManager, wasteFactory, strategyFactory);
        engine.run();
    }
}
