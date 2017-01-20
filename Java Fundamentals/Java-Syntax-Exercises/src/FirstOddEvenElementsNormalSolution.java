import java.util.ArrayList;
import java.util.Scanner;

public class FirstOddEvenElementsNormalSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split(" ");
        String[] command = scanner.nextLine().split(" ");

        int count = Integer.parseInt(command[1]);
        String type = command[2];

        int remainder = type.equals("even") ? 0 : 1;
        ArrayList<String> resultingNums = new ArrayList<>();

        for (int i = 0; i < elements.length; i++) {
            int currentNumber = Integer.parseInt(elements[i]);

            if (Math.abs(currentNumber) % 2 == remainder) {
                resultingNums.add(elements[i]);
            }

            if (resultingNums.size() == count){
                break;
            }
        }
        System.out.println(String.join(" ", resultingNums));
    }
}
