import java.util.LinkedHashSet;
import java.util.Scanner;

public class VoinaNumbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = getPlayerNumbers(scanner);
        LinkedHashSet<Integer> secondPlayer = getPlayerNumbers(scanner);

        int rounds = 0;

        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }

            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);

            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            } else {
                continue;
            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }
    }

    public static LinkedHashSet<Integer> getPlayerNumbers(Scanner scanner) {
        LinkedHashSet<Integer> player = new LinkedHashSet<>();
        String[] numbers = scanner.nextLine().split(" ");

        for (String number : numbers) {
            player.add(Integer.parseInt(number));
        }

        return player;
    }
}
