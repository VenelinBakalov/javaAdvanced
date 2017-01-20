import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int endIndex = 0; endIndex < expression.length(); endIndex++) {
            char symbol = expression.charAt(endIndex);
            if (symbol == '('){
                stack.push(endIndex);
            } else if (symbol == ')') {
                int startIndex = stack.pop();
                String currentExpr = expression.substring(startIndex, endIndex + 1);
                System.out.println(currentExpr);
            }
        }
    }
}
