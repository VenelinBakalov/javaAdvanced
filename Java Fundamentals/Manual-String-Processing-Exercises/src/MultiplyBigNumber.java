import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplyBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder firstNumber = new StringBuilder(reader.readLine());
        int multiplier = Integer.parseInt(reader.readLine());

        if (multiplier == 0) {
            System.out.println(0);
            return;
        }

        int overflow = 0;
        StringBuilder result = new StringBuilder();

        removeZeros(firstNumber);
        firstNumber.reverse();

        for (int i = 0; i < firstNumber.length(); i++) {
            int temp = Integer.parseInt(firstNumber.substring(i, i + 1));
            int currentResult = (temp * multiplier) + overflow;

            if (currentResult > 9) {
                overflow = currentResult / 10;
                currentResult %= 10;
            } else {
                overflow = 0;
            }

            result.insert(0, currentResult);
        }

        if (overflow != 0) {
            result.insert(0, overflow);
        }

        System.out.println(result);

    }
    private static void removeZeros(StringBuilder firstNumber) {
        while (firstNumber.charAt(0) == '0') {
            firstNumber.delete(0, 1);
        }
    }
}

