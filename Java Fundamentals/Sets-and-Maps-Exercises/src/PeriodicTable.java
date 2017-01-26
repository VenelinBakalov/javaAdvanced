import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int compoundCount = Integer.parseInt(scanner.nextLine());
        HashSet<String> chemicalElements = new HashSet<>();
        TreeSet<String> orderedElements = new TreeSet<>();

        for (int i = 0; i < compoundCount; i++) {
            String[] compound = scanner.nextLine().split(" ");
            for (String element : compound) {
                chemicalElements.add(element);
            }
        }

        orderedElements.addAll(chemicalElements);

        for (String orderedElement : orderedElements) {
            System.out.print(orderedElement + " ");
        }
    }
}
