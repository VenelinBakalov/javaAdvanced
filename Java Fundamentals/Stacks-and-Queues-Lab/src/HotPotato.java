import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s+");

        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue, kids);

        int counter = Integer.parseInt(scanner.nextLine());

        while (queue.size() > 1) {
            for (int i = 1; i < counter; i++) {
                String firstChild = queue.poll();
                queue.offer(firstChild);
            }

            System.out.println("Removed " + queue.poll());
        }
        System.out.printf("Last is %s", queue.poll());
    }
}