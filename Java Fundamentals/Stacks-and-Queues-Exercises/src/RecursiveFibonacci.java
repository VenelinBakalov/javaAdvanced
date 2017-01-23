import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int index = Integer.parseInt(scanner.nextLine());

        long fibonacciNumber = getFibonacci(index + 1);

        System.out.println(fibonacciNumber);
    }

    private static long getFibonacci(int index) {
        if (index == 1) {
            return 1;
        } else if (index == 0) {
           return 0;
        } else {
            return getFibonacci(index - 1) + getFibonacci(index - 2);
        }
    }
}
