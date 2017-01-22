import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParenthesisFromExer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] braces = scanner.nextLine().toCharArray();

        if (braces.length % 2 != 0) {
            System.out.println("NO");
            return;
        }

        Deque<Character> openBraces = new ArrayDeque<>();

        boolean isBalanced = true;

        for (char brace : braces) {
            if (brace == '{' || brace == '(' || brace == '[') {
                openBraces.push(brace);
            } else {
                char currentBrace = openBraces.pop();

                if (brace == '}') {
                    brace = '{';
                }
                if (brace == ')') {
                    brace = '(';
                }
                if (brace == ']') {
                    brace = '[';
                }

                if (brace != currentBrace) {
                    System.out.println("NO");
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        }
    }
}
