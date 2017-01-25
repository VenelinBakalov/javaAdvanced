import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] infix = scanner.nextLine().split(" ");

        Deque<String> operators = new ArrayDeque<>();

        for (int i = 0; i < infix.length; i++) {
            String currentSymbol = infix[i];

            if (!isOperator(currentSymbol)) {
                System.out.print(currentSymbol + " ");
            } else if ("*".equals(currentSymbol) || "/".equals(currentSymbol)) {
                while (!operators.isEmpty()) {
                    String previousSymbol = operators.pop();
                    if ("*".equals(previousSymbol) || "/".equals(previousSymbol)) {
                        System.out.print(previousSymbol + "");
                    } else {
                        operators.push(previousSymbol);
                        break;
                    }
                }
                operators.push(currentSymbol);
            } else if ("+".equals(currentSymbol) || "-".equals(currentSymbol)) {
                while (!operators.isEmpty()) {
                    String previousSymbol = operators.pop();
                    if ("*".equals(previousSymbol) || "/".equals(previousSymbol)
                            || "+".equals(previousSymbol) || "-".equals(previousSymbol)) {
                        System.out.print(previousSymbol + " ");
                    } else {
                        operators.push(previousSymbol);
                        break;
                    }
                }
                operators.push(currentSymbol);
            } else if ("(".equals(currentSymbol)) {
                operators.push(currentSymbol);
            } else if (")".equals(currentSymbol)) {
                while (!"(".equals(operators.peek())) {
                    System.out.print(operators.pop() + " ");
                }
                operators.pop();
            }
        }

        while (!operators.isEmpty()) {
            System.out.print(operators.poll() + " ");
        }

    }

    private static boolean isOperator(String symbol) {
        return "+".equals(symbol) || "-".equals(symbol) || "*".equals(symbol) || "/".equals(symbol)
                || "^".equals(symbol) || "(".equals(symbol) || ")".equals(symbol);
    }
}
