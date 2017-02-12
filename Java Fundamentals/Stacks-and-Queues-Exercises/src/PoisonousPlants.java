import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int initialPlantsCount = Integer.parseInt(reader.readLine());
        int[] plants = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> plantsLeft = new ArrayDeque<>();

        int day = 0;

        while (true) {
            if (plants.length == 1) {
                System.out.println(day);
                return;
            }

            for (int i = plants.length - 1; i >= 1; i--) {
                int leftPlant = plants[i-1];
                int currentPlant = plants[i];

                if (currentPlant <= leftPlant) {
                    plantsLeft.push(currentPlant);
                }

                if (i == 1) {
                    plantsLeft.push(leftPlant);
                }
            }

            if (plantsLeft.size() == plants.length) {
                System.out.println(day);
                return;
            }

            day++;
            plants = new int[plantsLeft.size()];

            for (int i = 0; i < plants.length; i++) {
                plants[i] = plantsLeft.poll();
            }

        }

    }
}
