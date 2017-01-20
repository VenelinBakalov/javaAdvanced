import java.util.ArrayList;
import java.util.Scanner;

public class VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] vehicles = scanner.nextLine().split("\\s+");

        ArrayList<String> vehiclePark = new ArrayList<>();

        for (String vehicle : vehicles) {
            vehiclePark.add(vehicle);
        }

        String[] vehicleRequest = scanner.nextLine().split(" ");

        int sold = 0;

        while (!vehicleRequest[0].equals("End")) {
            char carType = vehicleRequest[0].toLowerCase().charAt(0);
            int seats = Integer.parseInt(vehicleRequest[2]);

            boolean soldCar = false;

            for (int i = 0; i < vehiclePark.size(); i++) {
                String vehicle = vehiclePark.get(i);
                char currentCarType = vehicle.charAt(0);
                int currentCarSeats = Integer.valueOf(vehicle.substring(1));

                if (carType == currentCarType && seats == currentCarSeats) {
                    int price = currentCarType * currentCarSeats;
                    System.out.printf("Yes, sold for %d$%n", price);
                    sold++;
                    vehiclePark.remove(i);
                    soldCar = true;
                    break;
                }
            }

            if (soldCar == false) {
                System.out.println("No");
            }

            vehicleRequest = scanner.nextLine().split(" ");
        }

        String park = String.join(", ", vehiclePark);
        System.out.printf("Vehicles left: %s%n", park);


        System.out.printf("Vehicles sold: %d", sold);
    }
}
