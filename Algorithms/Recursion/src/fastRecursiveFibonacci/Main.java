package fastRecursiveFibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 5.5.2017 г..
 */
public class Main {

    private static long[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int fibCount = Integer.parseInt(reader.readLine());

        memo = new long[fibCount + 1];

        long fibonacci = calculateFibonacci(fibCount);

        System.out.println(fibonacci);
    }

    private static long calculateFibonacci(int n) {
        if (memo[n] == 0) {
            // fib[n] is still not calculated

            if ((n == 1) || (n == 2)) {
                memo[n] = 1;
            } else {
                memo[n] = calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
            }
        }

        return memo[n];
    }
}
