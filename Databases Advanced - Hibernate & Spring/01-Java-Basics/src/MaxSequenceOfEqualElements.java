import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by Venelin on 27.6.2017 г..
 */
public class MaxSequenceOfEqualElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] sequence = Stream.of(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int bestStartIndex = 0;
        int bestLength = 1;

        for (int i = 0; i < sequence.length - 1; i++) {
            int currentLen = 1;
            for (int nextElement = i + 1; nextElement < sequence.length; nextElement++) {
                if (Objects.equals(sequence[i], sequence[nextElement])) {
                    currentLen++;
                } else {
                    break;
                }
            }
            if (currentLen > bestLength) {
                bestLength = currentLen;
                bestStartIndex = i;
            }
        }

        for (int i = 0; i < bestLength; i++) {
            System.out.print(sequence[bestStartIndex] + " ");
        }
    }
}
