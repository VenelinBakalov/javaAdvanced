package vehiclesExer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created by Venelin on 6.7.2017 г..
 */
public class Main {

    private static Vehicle car;
    private static Vehicle truck;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carInfo = reader.readLine().split("\\s+");
        String[] truckInfo = reader.readLine().split("\\s+");

        car = new Car(Double.parseDouble(carInfo[1]),
                Double.parseDouble(carInfo[2]));
        truck = new Truck(Double.parseDouble(truckInfo[1]),
                Double.parseDouble(truckInfo[2]));

        int commandCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < commandCount; i++) {
            String[] commandArgs = reader.readLine().split("\\s+");
            if (commandArgs.length != 3) continue;

            String command = commandArgs[0].toLowerCase();
            String vehicleType = commandArgs[1];
            Double km = Double.parseDouble(commandArgs[2]);

            switch (command) {
                case "drive":
                    drive(vehicleType, km);
                    break;
                case "refuel":
                    refuel(vehicleType, km);
                    break;
            }
        }

        System.out.println(String.format("Car: %.2f", car.getQuantity()));
        System.out.println(String.format("Truck: %.2f", truck.getQuantity()));
    }

    public static void drive(String type, Double km) {
        DecimalFormat df = new DecimalFormat("0.########");

        switch (type) {
            case "Car":
                if (car.canTravel(km)) {
                    car.drive(km);
                    System.out.println(String.format("Car travelled %s km", df.format(km)));
                } else {
                    System.out.println("Car needs refueling");
                }
                break;
            case "Truck":
                if (truck.canTravel(km)) {
                    truck.drive(km);
                    System.out.println(String.format("Truck travelled %s km", df.format(km)));
                } else {
                    System.out.println("Truck needs refueling");
                }
                break;
        }
    }

    public static void refuel(String type, Double km) {
        switch (type) {
            case "Car":
                car.refuel(km);
                break;
            case "Truck":
                truck.refuel(km);
                break;
        }
    }
}
