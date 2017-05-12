package LIS;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 11.5.2017 г..
 */
public class Main {

    public static void main(String[] args) {

        int[] seq = new int[] {3, 14, 5, 12, 15, 7, 8, 9, 11, 10, 1 };
        int[] len = new int[seq.length];
        int[] prev = new int[seq.length];

        int lisIndex = calculateLongestIncreasingSubsequence(seq, len, prev);

        printLongestIncreasingSubsequence(seq, prev, lisIndex);

    }

    // Leftmost LIS
    // Solution with n^2 complexity
    private static int calculateLongestIncreasingSubsequence(int seq[], int[] len, int[] prev) {

        int maxIndex = 0;
        int maxLen = 0;

        for (int x = 0; x < seq.length; x++) {
            len[x] = 1;
            prev[x] = -1;

            for (int i = 0; i < x; i++) {
                if (seq[x] > seq[i] && len[i] + 1 > len[x]) {
                    len[x] = len[i] + 1;
                    prev[x] = i;

                }
            }

            if (len[x] > maxLen) {
                maxLen = len[x];
                maxIndex = x;
            }
        }

        return maxIndex;
    }

    private static void printLongestIncreasingSubsequence(int[] seq, int[] prev, int index) {
        List<Integer> lis = new ArrayList<>();

        while (index != -1) {
            lis.add(0, seq[index]);
            index = prev[index];
        }

        System.out.println(String.join(", ", lis.stream().map(Object::toString).collect(Collectors.toList())));
    }
}
