import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Created by Venelin on 27.6.2017 г..
 */
public class MaxSequenceOfIncreasingElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] sequence = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int longestSequence = 1;
        int sequenceIndex = 0;

        for (int i = 0; i < sequence.length - 1; i++) {
            int currentSequence = 1;

            for (int j = i + 1; j < sequence.length; j++) {
                if (sequence[j - 1] < sequence[j]) {
                    currentSequence++;
                } else {
                    break;
                }
            }

            if (currentSequence > longestSequence) {
                longestSequence = currentSequence;
                sequenceIndex = i;
            }
        }

        for (int i = sequenceIndex; i < sequenceIndex + longestSequence; i++) {
            System.out.print(sequence[i] + " ");
        }
    }
}
