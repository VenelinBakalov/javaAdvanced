import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int countToPush = Integer.parseInt(input[0]);
        int countToPop = Integer.parseInt(input[1]);
        int element = Integer.parseInt(input[2]);

        String[] numbers = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int minElement = Integer.MAX_VALUE;

        for (int i = 0; i < countToPush; i++) {
            stack.push(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < countToPop; i++) {
            stack.pop();
        }

        if (stack.contains(element)) {
            System.out.println(true);
        } else if (stack.size() == 0){
            System.out.println("0");
        } else {

            for (Integer integer : stack) {
                if (integer < minElement){
                    minElement = integer;
                }
            }

            System.out.println(minElement);
        }
    }
}
