import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParenthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] parenthesis = scanner.nextLine().toCharArray();

        Deque<Integer> roundParenthesis = new ArrayDeque<>();
        Deque<Integer> squareParenthesis = new ArrayDeque<>();
        Deque<Integer> curlyParenthesis = new ArrayDeque<>();

        for (int endIndex = 0; endIndex < parenthesis.length; endIndex++) {
            char parenthesi = parenthesis[endIndex];
            Integer startIndex = -1;
            switch (parenthesi) {
                case '{': curlyParenthesis.push(endIndex); break;
                case '[': squareParenthesis.push(endIndex); break;
                case '(': roundParenthesis.push(endIndex); break;

                case '}':
                    startIndex = curlyParenthesis.poll();
                    if (startIndex == null || (startIndex + endIndex) % 2 != 1){
                        System.out.println("NO");
                        return;
                    }
                    break;

                case ']':
                    startIndex = squareParenthesis.poll();
                    if (startIndex == null || (startIndex + endIndex) % 2 != 1){
                        System.out.println("NO");
                        return;
                    }
                    break;

                case ')':
                    startIndex = roundParenthesis.poll();
                    if (startIndex == null || (startIndex + endIndex) % 2 != 1){
                        System.out.println("NO");
                        return;
                    }
                    break;
            }
        }

        if (roundParenthesis.isEmpty() && squareParenthesis.isEmpty() && curlyParenthesis.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}