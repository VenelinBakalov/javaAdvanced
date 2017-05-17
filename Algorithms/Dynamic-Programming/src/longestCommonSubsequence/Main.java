package longestCommonSubsequence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 17.5.2017 г..
 */
public class Main {

    private static final int NOT_CALCULATED = 0;
    private static String firstStr;
    private static String secondStr;
    private static int[][] lcs;

    public static void main(String[] args) {
        firstStr = "team";
        secondStr = "tree";
        lcs = new int[firstStr.length() + 1][secondStr.length() + 1];

        calcLCSRecursive(firstStr.length(), secondStr.length());

        String lcs = recoverLCS(firstStr.length(), secondStr.length());

        System.out.println(lcs);
    }

    private static String recoverLCS(int x, int y) {
        List<Character> lcsLetters = new ArrayList<>();

        while (x > 0 && y > 0) {
            if (firstStr.charAt(x - 1) == secondStr.charAt(y - 1) &&
                    (calcLCSRecursive(x - 1, y - 1) + 1 == lcs[x][y])) {
                lcsLetters.add(0, firstStr.charAt(x - 1));
                x--;
                y--;
            } else if (calcLCSRecursive(x - 1, y) == lcs[x][y]) {
                x--;
            } else {
                y--;
            }
        }

        return String.join("", lcsLetters.stream().map(Object::toString).collect(Collectors.toList()));
    }

    private static int calcLCSRecursive(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }

        if (lcs[x][y] == NOT_CALCULATED) {
            int lcsFirstMinusOne = calcLCSRecursive(x - 1, y);
            int lcsSecondMinusOne = calcLCSRecursive(x, y - 1);
            lcs[x][y] = Math.max(lcsFirstMinusOne, lcsSecondMinusOne);

            if (x > 0 && y > 0 && firstStr.charAt(x - 1) == secondStr.charAt(y - 1)) {
                int lcsBothMinusOne = 1 + calcLCSRecursive(x - 1, y - 1);
                lcs[x][y] = Math.max(lcs[x][y], lcsBothMinusOne);
            }
        }

        return lcs[x][y];
    }

    private static void calcLCSIterative() {
        for (int first = 1; first < lcs.length; first++) {
            for (int second = 1; second < lcs[first].length; second++) {
                if (firstStr.charAt(first - 1) == secondStr.charAt(second - 1)) {
                    lcs[first][second] = lcs[first - 1][second - 1] + 1;
                } else {
                    lcs[first][second] = Math.max(lcs[first - 1][second], lcs[first][second - 1]);
                }
            }
        }
    }
}
