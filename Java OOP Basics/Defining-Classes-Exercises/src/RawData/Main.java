package rawData;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int carsAmount = Integer.parseInt(reader.readLine());

        Set<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < carsAmount; i++) {
            Car car = null;
            String[] carInfo = reader.readLine().split(" ");
            String carModel = carInfo[0];

            int engineSpeed = Integer.parseInt(carInfo[1]);
            int enginePower = Integer.parseInt(carInfo[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Set<Tire> tires = new HashSet<>();

            for (int tireIndex = 5; tireIndex < carInfo.length; tireIndex += 2) {
                double tirePressure = Double.parseDouble(carInfo[tireIndex]);
                int tireAge = Integer.parseInt(carInfo[tireIndex + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
            }

            car = new Car(carModel, engine, cargo, tires);
            cars.add(car);
        }

        String command = reader.readLine();

        switch (command) {
            case "fragile":
                cars.stream()
                        .filter(c -> c.getCargo().getType().equals("fragile"))
                        .filter(c -> c.getTires().stream()
                                .filter(tire -> {
                                    return tire.getPressure() < 1;
                                }).collect(Collectors.toList()).size() > 0)
                        .forEach(System.out::println);
                break;

            case "flamable":
                cars.stream()
                        .filter(c -> c.getCargo().getType().equals("flamable"))
                        .filter(c -> c.getEngine().getPower() > 250)
                        .forEach(System.out::println);
                break;
        }
    }
}
