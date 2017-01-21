import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> reversedNumbers = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            reversedNumbers.push(Integer.parseInt(numbers[i]));
        }

        while (reversedNumbers.size() > 0) {
            System.out.print(reversedNumbers.pop() + " ");
        }
    }
}
