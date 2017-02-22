package speedRacing;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ROOT);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int carsCount = Integer.parseInt(reader.readLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < carsCount; i++) {
            String[] carArgs = reader.readLine().split(" ");
            String model = carArgs[0];
            double fuelAmount = Double.parseDouble(carArgs[1]);
            double fuelCostPerKm = Double.parseDouble(carArgs[2]);

            speedRacing.Car car = new speedRacing.Car(model, fuelAmount, fuelCostPerKm);
            cars.put(car.getModel(), car);
        }

        String command;

        while (!"End".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(" ");
            String model = commandArgs[1];
            int distance = Integer.parseInt(commandArgs[2]);

            speedRacing.Car car = cars.get(model);
            car.drive(distance);
        }

        cars.values().forEach(System.out::println);

    }
}
