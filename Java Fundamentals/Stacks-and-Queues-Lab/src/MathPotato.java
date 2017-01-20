import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s+");

        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue, kids);

        int counter = Integer.parseInt(scanner.nextLine());

        int primeCounter = 1;

        while (queue.size() > 1) {
            for (int i = 1; i < counter; i++) {
                String firstChild = queue.poll();
                queue.offer(firstChild);
            }

            if (isPrime(primeCounter)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }

            primeCounter++;
        }
        System.out.printf("Last is %s", queue.poll());
    }

    private static boolean isPrime(int number) {

        if (number <= 1) {
            return false;
        }

        for (int divider = 2; divider <= Math.sqrt(number); divider++) {
            if (number % divider == 0) {
                return false;
            }
        }

        return true;
    }
}