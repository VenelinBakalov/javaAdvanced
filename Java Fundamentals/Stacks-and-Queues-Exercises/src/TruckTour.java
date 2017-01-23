import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class TruckTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pumpCount = Integer.parseInt(scanner.nextLine());

        ArrayList<Pump> pumps = new ArrayList<>();

        for (int i = 0; i < pumpCount; i++) {
            String[] pumpStationInput = scanner.nextLine().split("\\s+");

            long petrol = Long.parseLong(pumpStationInput[0]);
            long distance = Long.parseLong(pumpStationInput[1]);

            Pump pump = new Pump(petrol, distance);
            pumps.add(pump);
        }

        Deque<Pump> stationsQueue = new ArrayDeque<>();

        for (Pump pump : pumps) {
            stationsQueue.add(pump);
        }

        int index = 0;

        for (int i = 0; i < pumpCount; i++) {

            long petrol = 0;

            for (Pump pump : stationsQueue) {            // other option to iterate over the collection is to call
                petrol += pump.getPetrolDifference();    // stationsQueue.toArray and to iterate over the new array

                if (petrol < 0){
                    break;
                }
            }

            if (petrol >= 0) {
                index = i;
                break;
            }

            stationsQueue.add(stationsQueue.remove());
        }

        System.out.println(index);
    }

    public static class Pump{
        long petrol;

        long distanceToNextPump;

        long petrolDifference;

        public Pump(long petrol, long distanceToNextPump) {
            this.petrol = petrol;
            this.distanceToNextPump = distanceToNextPump;
            this.petrolDifference = petrol - distanceToNextPump;
        }

        public long getPetrol() {
            return petrol;
        }

        public void setPetrol(long petrol) {
            this.petrol = petrol;
        }

        public long getDistanceToNextPump() {
            return distanceToNextPump;
        }

        public void setDistanceToNextPump(long distanceToNextPump) {
            this.distanceToNextPump = distanceToNextPump;
        }

        public long getPetrolDifference() {
            return petrolDifference;
        }

        public void setPetrolDifference(long petrolDifference) {
            this.petrolDifference = petrolDifference;
        }
    }
}
