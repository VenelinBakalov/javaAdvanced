import java.util.*;

public class EvaluateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] infix = scanner.nextLine().split(" ");

        Deque<String> operators = new ArrayDeque<>();
        Deque<String> output = new ArrayDeque<>();

        for (int i = 0; i < infix.length; i++) {
            String currentSymbol = infix[i];

            if (!isOperator(currentSymbol)) {
                output.push(currentSymbol);
            } else if ("*".equals(currentSymbol) || "/".equals(currentSymbol)) {
                while (!operators.isEmpty()) {
                    String previousSymbol = operators.pop();
                    if ("*".equals(previousSymbol) || "/".equals(previousSymbol)) {
                        output.push(previousSymbol);
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
                        output.push(previousSymbol);
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
                    output.push(operators.pop());
                }
                operators.pop();
            }
        }

        while (!operators.isEmpty()) {
            output.push(operators.poll());
        }

        List<String> postfix = new ArrayList<>();

        while (!output.isEmpty()) {
            postfix.add(output.pollLast());
        }
        Deque<Double> stack = new ArrayDeque<>();

        double result = 0;
        for (String currentSym : postfix) {
            if (!isOperator(currentSym)) {
                stack.push(Double.valueOf(currentSym));
            } else {
                double temp = stack.pop();
                double tempTwo = stack.pop();
                double currentResult = 0;
                switch (currentSym) {
                    case "-": currentResult = tempTwo - temp; break;
                    case "+": currentResult = tempTwo + temp; break;
                    case "*": currentResult = tempTwo * temp; break;
                    case "/": currentResult = tempTwo / temp; break;
                }

                stack.push(currentResult);
            }
        }

        result = stack.poll();

        System.out.printf("%.2f", result);

    }

    private static boolean isOperator(String symbol) {
        return "+".equals(symbol) || "-".equals(symbol) || "*".equals(symbol) || "/".equals(symbol)
                || "^".equals(symbol) || "(".equals(symbol) || ")".equals(symbol);
    }
}
