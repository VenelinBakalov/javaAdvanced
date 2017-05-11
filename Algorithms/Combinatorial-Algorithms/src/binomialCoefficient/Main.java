package binomialCoefficient;

/**
 * Created by Venelin on 9.5.2017 г..
 */
public class Main {

    private static final int MAX = 100;
    private static long[][] binomCoeff = new long[MAX][MAX];

    public static void main(String[] args) {
        System.out.println(calculateBinomCoeff(4, 2));
        System.out.println(calculateBinomCoeff(10, 4));
        System.out.println(calculateBinomCoeff(13, 7));
        System.out.println(calculateBinomCoeff(26, 13));

    }

    private static long calculateBinomCoeff(int n, int k) {
        if (k > n) {
            return 0;
        }

        if (k == 0 || k == n) {
            return 1;
        }

        if (binomCoeff[n][k] == 0) {
            binomCoeff[n][k] = calculateBinomCoeff(n - 1, k - 1) + calculateBinomCoeff(n - 1, k);
        }

        return binomCoeff[n][k];
    }
}
