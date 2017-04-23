package hell.entities.engines;

import hell.entities.Repositories.Repository;
import hell.entities.commands.Executable;
import hell.entities.interpreter.Interpreter;
import hell.interfaces.Hero;
import hell.interfaces.InputReader;
import hell.interfaces.Item;
import hell.interfaces.OutputWriter;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public class Engine implements Runnable {

    private InputReader reader;
    private OutputWriter writer;
    private Interpreter interpreter;
    private Repository<Hero> heroRepository;

    public Engine(InputReader reader, OutputWriter writer, Interpreter interpreter, Repository<Hero> heroRepository) {
        this.reader = reader;
        this.writer = writer;
        this.interpreter = interpreter;
        this.heroRepository = heroRepository;
    }

    @Override
    public void run() {
        String commandLine = this.reader.readLine();

        while (true) {
            if ("Quit".equals(commandLine)) break;

            try {
                Executable command = this.interpreter.interpretCommand(commandLine);
                String result = command.execute();

                this.writer.writeLine(result);

                commandLine = reader.readLine();

            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        String result = this.getResultsString();

        this.writer.writeLine(result);
    }

    private String getResultsString() {
        StringBuilder sb = new StringBuilder();

        final int[] heroIndex = {0};
        this.heroRepository.getAll().stream()
                .sorted((h1, h2) -> {
                    long firstHeroSum = h1.getStrength() + h1.getAgility() + h1.getIntelligence();
                    long secondHeroSum = h2.getStrength() + h2.getAgility() + h2.getIntelligence();

                    if (Long.compare(secondHeroSum, firstHeroSum) == 0) {
                        long firstHeroPoints = h1.getHitPoints() + h1.getDamage();
                        long secondHeroPoints = h2.getHitPoints() + h2.getDamage();

                        return Long.compare(secondHeroPoints, firstHeroPoints);
                    } else {
                        return Long.compare(secondHeroSum, firstHeroSum);
                    }
                        }).forEach(hero -> {

            sb.append(String.format("%d. %s: %s", ++heroIndex[0], hero.getClass().getSimpleName(), hero.getName())).append(System.lineSeparator());
            sb.append(String.format("###HitPoints: %s", hero.getHitPoints())).append(System.lineSeparator());
            sb.append(String.format("###Damage: %s", hero.getDamage())).append(System.lineSeparator());
            sb.append(String.format("###Strength: %s", hero.getStrength())).append(System.lineSeparator());
            sb.append(String.format("###Agility: %s", hero.getAgility())).append(System.lineSeparator());
            sb.append(String.format("###Intelligence: %s", hero.getIntelligence())).append(System.lineSeparator());

            Collection<Item> items = hero.getItems();
            sb.append("###Items: ");
            sb.append(items.size() == 0 ? "None" :
                    String.join(", ", items.stream().map(Item::getName).collect(Collectors.toList())))
            .append(System.lineSeparator());
        });

        return sb.toString().trim();
    }

}
