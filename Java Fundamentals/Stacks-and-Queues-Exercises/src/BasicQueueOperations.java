import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int elementsToEnqueue = Integer.parseInt(input[0]);
        int elementsToDequeue = Integer.parseInt(input[1]);
        int elementToCheck = Integer.parseInt(input[2]);

        String[] numbers = scanner.nextLine().split("\\s+");

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < elementsToEnqueue; i++) {
            queue.add(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < elementsToDequeue; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(elementToCheck)) {
            System.out.println(true);
        } else {
            int minElement = Integer.MAX_VALUE;

            for (Integer integer : queue) {
                if (integer < minElement){
                    minElement = integer;
                }
            }

            System.out.println(minElement);
        }
    }
}
