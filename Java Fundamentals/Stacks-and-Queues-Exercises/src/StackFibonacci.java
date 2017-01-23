import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StackFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = Integer.parseInt(scanner.nextLine());

        Deque<Long> fibonacciNumbers = new ArrayDeque<>();

        fibonacciNumbers.add(Long.valueOf(1));
        fibonacciNumbers.add(Long.valueOf(1));

        for (int i = 1; i < index; i++) {
            Long previousNumber = fibonacciNumbers.pop();
            Long currentNumber = previousNumber + fibonacciNumbers.peek();
            fibonacciNumbers.push(previousNumber);
            fibonacciNumbers.push(currentNumber);
        }

        System.out.println(fibonacciNumbers.pop());
    }
}
