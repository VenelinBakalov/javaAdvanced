import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] count = scanner.nextLine().split(" ");

        int firstSetSize = Integer.parseInt(count[0]);
        int secondSetSize = Integer.parseInt(count[1]);

        LinkedHashSet<String> firstSet = new LinkedHashSet<>();
        LinkedHashSet<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(scanner.nextLine());
        }

        for (int i = 0; i < secondSetSize; i++) {
            secondSet.add(scanner.nextLine());
        }

        for (String number : firstSet) {
            if (secondSet.contains(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
