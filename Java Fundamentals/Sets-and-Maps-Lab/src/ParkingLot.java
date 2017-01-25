import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> parkingLot = new HashSet<>();

        while (true) {
            String[] commandLine = scanner.nextLine().split(", ");

            if ("END".equals(commandLine[0])) {
                break;
            }

            String command = commandLine[0];
            String carNumber = commandLine[1];

            switch (command) {
                case "IN":
                    parkingLot.add(carNumber);
                    break;
                case "OUT":
                    parkingLot.remove(carNumber);
            }
        }

        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parkingLot) {
                System.out.println(car);
            }
        }
    }
}
