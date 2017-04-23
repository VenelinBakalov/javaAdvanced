package hell;

import hell.entities.Repositories.HeroRepository;
import hell.entities.Repositories.Repository;
import hell.entities.engines.Engine;
import hell.entities.factories.Factory;
import hell.entities.factories.HeroFactory;
import hell.entities.interpreter.CommandInterpreter;
import hell.entities.interpreter.Interpreter;
import hell.entities.io.ConsoleReader;
import hell.entities.io.ConsoleWriter;
import hell.interfaces.Hero;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();

        Repository<Hero> heroRepository = new HeroRepository();
        Factory<Hero> heroFactory = new HeroFactory();

        Interpreter commandInterpreter = new CommandInterpreter(heroRepository, heroFactory);

        Runnable engine = new Engine(reader, writer, commandInterpreter, heroRepository);

        engine.run();
    }
}