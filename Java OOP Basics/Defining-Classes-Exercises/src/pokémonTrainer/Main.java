package pokémonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Map<String, Trainer> trainers = new HashMap<>();

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

        }
    }
}
