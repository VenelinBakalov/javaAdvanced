package binomialCoefficients;

/**
 * Created by Venelin on 18.5.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        int n = 10;
        int k = 5;
        int[] firstRow = new int[n + 1];
        firstRow[0] = 1;
        int[] secondRow = new int[n + 1];
        secondRow[0] = secondRow[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                // first position is always 1 so we start from index 1
                for (int j = 1; j < i; j++) {
                    firstRow[j] = secondRow[j - 1] + secondRow[j];
                }

                firstRow[i] = 1;
            } else {
                for (int j = 1; j < i; j++) {
                    secondRow[j] = firstRow[j - 1] + firstRow[j];
                }

                secondRow[i] = 1;
            }
        }

        if (n % 2 == 0) {
            System.out.println(firstRow[k]);
        } else {
            System.out.println(secondRow[k]);
        }
    }
}
