package pokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!"Tournament".equals(line = reader.readLine())) {
            String[] catchArgs = line.split(" ");
            String trainerName = catchArgs[0];

            if (!trainers.containsKey(trainerName)) {
                Trainer trainer = new Trainer(trainerName);
                trainers.put(trainerName, trainer);
            }
            Trainer trainer = trainers.get(trainerName);

            String pokemonName = catchArgs[1];
            String pokemonType = catchArgs[2];
            int pokemonHealth = Integer.parseInt(catchArgs[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonType, pokemonHealth);
            trainer.getPokemons().add(pokemon);
        }

        String command;

        while (!"End".equals(command = reader.readLine())) {
            for (Trainer trainer : trainers.values()) {
                String type = command;
                long elementCount = trainer.getPokemons().stream().filter(pokemon -> type.equals(pokemon.getElement())).count();
                if (elementCount > 0) {
                    trainer.setBadgeCount(trainer.getBadgeCount() + 1);
                } else {
                    trainer.getPokemons()
                            .forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
                    trainer.setPokemons(trainer.getPokemons().stream()
                            .filter(pokemon -> pokemon.getHealth() > 0)
                            .collect(Collectors.toSet()));
                }
            }
        }

        trainers.values().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getBadgeCount(), t1.getBadgeCount()))
                .forEach(System.out::println);
    }
}
