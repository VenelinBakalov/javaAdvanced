import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

public class PoisonousPlantsRework {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int initialPlantsCount = Integer.parseInt(reader.readLine());
        int[] plants = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> plantsLeft = new ArrayDeque<>();

        int day = 0;

        while (true) {

            boolean willPlantsDieNextDay = false;

            plantsLeft.push(plants[0]);

            for (int i = 1; i < plants.length; i++) {
                int currentPlant = plants[i];
                int previousPlant = plants[i - 1];

                if (currentPlant <= previousPlant) {
                    int lastPlant = plantsLeft.peek();
                    if (currentPlant > lastPlant) {
                        willPlantsDieNextDay = true;
                    }
                    plantsLeft.push(currentPlant);
                }
            }
            day++;

            if (!willPlantsDieNextDay) {
                System.out.println(day);
                return;
            }

            plants = new int[plantsLeft.size()];

            for (int i = plants.length - 1; i >= 0; i--) {
                plants[i] = plantsLeft.poll();
            }

        }
    }
}
