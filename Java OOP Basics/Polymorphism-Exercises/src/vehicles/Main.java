package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carArgs = reader.readLine().split("\\s+");
        String[] truckArgs = reader.readLine().split("\\s+");
        String[] busArgs = reader.readLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carArgs[1]), Double.parseDouble(carArgs[2]), Double.parseDouble(carArgs[3]));
        Truck truck = new Truck(Double.parseDouble(truckArgs[1]), Double.parseDouble(truckArgs[2]), Double.parseDouble(truckArgs[3]));
        Bus bus = new Bus(Double.parseDouble(busArgs[1]), Double.parseDouble(busArgs[2]), Double.parseDouble(busArgs[3]));

        int commandCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < commandCount; i++) {
            String[] commandArgs = reader.readLine().split(" ");
            String command = commandArgs[0];
            String vehicle = commandArgs[1];
            double amount = Double.parseDouble(commandArgs[2]);

            try {
                switch (vehicle.toLowerCase()) {
                    case "car":
                        executeCommand(car, command, amount);
                        break;
                    case "truck":
                        executeCommand(truck, command, amount);
                        break;
                    case "bus":
                        if (command.toLowerCase().equals("driveempty")) {
                            bus.driveEmpty(amount);
                        } else {
                            executeCommand(bus, command, amount);
                        }
                        break;
                }
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }


    private static void executeCommand(Vehicle vehicle, String command, double amount) {
        switch (command.toLowerCase()) {
            case "drive":
                vehicle.drive(amount);
                break;
            case "refuel":
                vehicle.refuel(amount);
                break;
        }
    }
}
