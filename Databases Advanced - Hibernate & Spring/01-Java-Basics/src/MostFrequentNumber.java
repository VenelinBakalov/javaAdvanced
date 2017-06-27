import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Venelin on 27.6.2017 г..
 */
public class MostFrequentNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] sequence = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int maxFrequencyCount = 1;
        int maxFrequencyIndex = 0;

        Set<Integer> checkedNums = new HashSet<>();

        for (int i = 0; i < sequence.length - 1; i++) {
            int currentFrequency = 1;
            // Is this really optimized? Removes unnecessary checks for duplicate numbers but iterates over the set to
            // search for their existence....I suppose it depends on the collection itself.
            if (checkedNums.contains(sequence[i])) {
                continue;
            }
            checkedNums.add(sequence[i]);

            for (int j = i + 1; j < sequence.length; j++) {
                if (sequence[i] == sequence[j]) {
                    currentFrequency++;
                }
            }

            if (currentFrequency > maxFrequencyCount) {
                maxFrequencyCount = currentFrequency;
                maxFrequencyIndex = i;
            }
        }

        System.out.println(sequence[maxFrequencyIndex]);
    }
}
