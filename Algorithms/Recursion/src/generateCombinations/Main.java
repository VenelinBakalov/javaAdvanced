package generateCombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 4.5.2017 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int startNum = 4;
        int endNum = 8;

        int[] temp = new int[count];
        generateCombinations(temp, 0, startNum, endNum);
    }

    private static void generateCombinations(int[] temp, int index, int startNum, int endNum) {
        if (index >= temp.length) {
            // A combination was found -> print it
            System.out.println(String.join(", ", Arrays.stream(temp).mapToObj(String::valueOf).collect(Collectors.toList())));
        } else {
            for (int i = startNum; i <= endNum; i++) {
                temp[index] = i;
                generateCombinations(temp, index + 1, i + 1, endNum);
            }
        }
    }
}
