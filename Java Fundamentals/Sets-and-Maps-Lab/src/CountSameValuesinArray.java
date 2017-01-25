import java.util.HashMap;
import java.util.Scanner;

public class CountSameValuesinArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> numbersCount = new HashMap<>();

        String[] numbers = scanner.nextLine().split(" ");

        for (String number : numbers) {
            if (!numbersCount.containsKey(number)) {
                numbersCount.put(number, 0);
            }

            numbersCount.put(number, numbersCount.get(number) + 1);
        }

        for (String number : numbersCount.keySet()) {
            System.out.printf("%s - %s times%n", number, numbersCount.get(number));
        }
    }
}
