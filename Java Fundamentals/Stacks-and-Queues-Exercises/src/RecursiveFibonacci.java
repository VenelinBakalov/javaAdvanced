import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        long fibonacciNumber = getFibonacci(count + 1);

        System.out.println(fibonacciNumber);
    }

    private static long getFibonacci(int count) {
        long fibonacciNumber = 1;
        if (count == 1) {
            fibonacciNumber = 1;
        } else if (count == 0) {
            fibonacciNumber = 0;
        } else {
            fibonacciNumber = getFibonacci(count - 1) + getFibonacci(count - 2);
        }
        return fibonacciNumber;
    }
}
