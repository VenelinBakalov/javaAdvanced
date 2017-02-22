package carSalesman;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int engineCount = Integer.parseInt(reader.readLine());
        Map<String, Engine> engines = new HashMap<>();

        for (int i = 0; i < engineCount; i++) {
            String[] engineArgs = reader.readLine().split(" ");
            String model = engineArgs[0];
            int power = Integer.parseInt(engineArgs[1]);

            Engine engine = new Engine(model, power);

            if (engineArgs.length == 3) {
                if (Character.isDigit(engineArgs[2].charAt(0))) {
                    String displacement = engineArgs[2];
                    engine.setDisplacement(displacement);
                } else {
                    String efficiency = engineArgs[2];
                    engine.setEfficiency(efficiency);
                }
            } else if (engineArgs.length == 4) {
                String displacement = engineArgs[2];
                String efficiency = engineArgs[3];
                engine.setDisplacement(displacement);
                engine.setEfficiency(efficiency);
            }

            engines.put(engine.getModel(), engine);
        }

        int carsCount = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carsCount; i++) {
            String[] carArgs = reader.readLine().split(" ");
            String model = carArgs[0];
            String engineModel = carArgs[1];
            Engine engine = engines.get(engineModel);

            Car car = new Car(model, engine);

            if (carArgs.length == 3) {
                if (Character.isDigit(carArgs[2].charAt(0))) {
                    String weight = carArgs[2];
                    car.setWeight(weight);
                } else {
                    String color = carArgs[2];
                    car.setColor(color);
                }
            } else if (carArgs.length == 4) {
                String weight = carArgs[2];
                String color = carArgs[3];
                car.setWeight(weight);
                car.setColor(color);
            }

            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
