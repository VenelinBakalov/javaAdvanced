import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ArraySlider {
    private static List<BigInteger> list = new ArrayList<>();
    private static Integer currentIndex = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().trim().split("\\s+");
        for (String remainder : input) {
            list.add(new BigInteger(remainder));
        }

        String command;

        while (!"stop".equals(command = reader.readLine())) {
            String[] tokens = command.split(" ");
            int offset = Integer.parseInt(tokens[0]);
            String operation = tokens[1];
            BigInteger operand = new BigInteger(tokens[2]);

            findIndex(offset);

            operationExecute(operation, operand);
        }


        System.out.println(list);
    }

    private static void operationExecute(String operation, BigInteger operand) {
        switch (operation) {

            case "&":
                list.set(currentIndex, list.get(currentIndex).and(operand));
                break;
            case "|":
                list.set(currentIndex, list.get(currentIndex).or(operand));
                break;
            case "^":
                list.set(currentIndex, list.get(currentIndex).xor(operand));
                break;
            case "+":
                list.set(currentIndex, list.get(currentIndex).add(operand));
                break;
            case "-":
                if (list.get(currentIndex).subtract(operand).compareTo(BigInteger.ZERO) == -1) {
                    list.set(currentIndex, BigInteger.ZERO);
                } else {
                list.set(currentIndex, list.get(currentIndex).subtract(operand));
                break;
                }
            case "*":
                list.set(currentIndex, list.get(currentIndex).multiply(operand));
                break;
            case "/":
                list.set(currentIndex, list.get(currentIndex).divide(operand));
                break;
            default:
                break;
        }
    }

    private static void findIndex(int offset) {
        offset %= list.size();
        currentIndex += offset;

        if (currentIndex >= list.size()) {
            currentIndex %= list.size();
        } else if (currentIndex < 0) {
            currentIndex = list.size() - Math.abs(currentIndex);
        }

    }
}
