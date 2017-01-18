import java.util.ArrayList;
import java.util.Scanner;

public class GroupNumbersWithList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");

        ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();
        numbers.add(0, new ArrayList<>());
        numbers.add(1, new ArrayList<>());
        numbers.add(2, new ArrayList<>());

        for (String number : input) {
            int currentNumber = Integer.parseInt(number);
            numbers.get(Math.abs(currentNumber) % 3).add(currentNumber);
        }

        for (ArrayList<Integer> number : numbers) {
            for (Integer integer : number) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
