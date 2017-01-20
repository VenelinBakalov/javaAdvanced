import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);

        while (stack.size() > 1) {
            int firstNumber = Integer.valueOf(stack.pop());
            String operator = stack.pop();
            int secondNumber = Integer.valueOf(stack.pop());

            switch (operator) {
                case "+":
                    stack.push(String.valueOf(firstNumber + secondNumber));
                    break;
                case "-":
                    stack.push(String.valueOf(firstNumber - secondNumber));
                    break;
            }
        }

        System.out.println(stack.pop());
    }
}
