import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class TruckTourWithoutClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pumpCount = Integer.parseInt(scanner.nextLine());

        ArrayList<long[]> pumps = new ArrayList<>();

        for (int i = 0; i < pumpCount; i++) {
            String[] pumpStationInput = scanner.nextLine().split("\\s+");

            long petrol = Long.parseLong(pumpStationInput[0]);
            long distance = Long.parseLong(pumpStationInput[1]);

            long[] pump = new long[] { petrol, distance};
            pumps.add(pump);
        }

        Deque<long[]> stationsQueue = new ArrayDeque<>();

        for (long[] pump : pumps) {
            stationsQueue.add(pump);
        }

        int index = 0;

        for (int i = 0; i < pumpCount; i++) {

            long totalPetrol = 0;

            for (long[] pump : stationsQueue) {
                long stationPetrol = pump[0];
                long distance = pump[1];
                long petrolDifference = stationPetrol - distance;
                totalPetrol += petrolDifference;

                if (totalPetrol < 0){
                    break;
                }
            }

            if (totalPetrol >= 0) {
                index = i;
                break;
            }

            stationsQueue.add(stationsQueue.remove());
        }

        System.out.println(index);
    }

}
