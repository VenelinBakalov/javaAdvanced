import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SequenceWithQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long number = Long.parseLong(scanner.nextLine());

        Queue<Long> queue = new ArrayDeque<>();

        queue.add(number);

        for (int i = 0; i < 50; i++) {
            long secondElement = number + 1;
            long thirdElement = (2 * number) + 1;
            long fourthElement = number + 2;
            queue.add(secondElement);
            queue.add(thirdElement);
            queue.add(fourthElement);
            System.out.print(queue.remove() + " ");

            number = queue.peek();
        }
    }
}
