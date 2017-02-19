import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Stream;

public class Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int wavesCount = Integer.parseInt(reader.readLine());

        List<Integer> waves = new ArrayList<>();
        Deque<Deque<Integer>> activities = new ArrayDeque<>();

        for (int i = 0; i < wavesCount; i++) {
            int[] currentValues = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Deque<Integer> currentSeism = new ArrayDeque<>();
            for (int currentValue : currentValues) {
                currentSeism.add(currentValue);
            }
            activities.add(currentSeism);
        }

        int seismicitiesAmount = 0;

        while (!activities.isEmpty()) {
            Deque<Integer> currentSeism = activities.pop();

            int seismicity = currentSeism.pop();
            seismicitiesAmount++;
            int iterateLenght = currentSeism.size();

            for (int j = 0; j < iterateLenght; j++) {
                int nextSeism = currentSeism.pop();
                if (seismicity < nextSeism) {
                    currentSeism.push(nextSeism);
                    activities.add(currentSeism);
                    break;
                }
            }
            waves.add(seismicity);
        }

        StringBuilder result = new StringBuilder();
        result.append(seismicitiesAmount).append("\r\n");
        for (Integer wave : waves) {
            result.append(wave).append(" ");
        }

        System.out.println(result);
    }
}
