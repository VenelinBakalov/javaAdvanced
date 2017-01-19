import java.util.Scanner;

public class HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int target = Integer.parseInt(scanner.nextLine());

        for (int firstNum = 1; firstNum <= 20; firstNum++) {
            for (int secondNum = 1; secondNum <= 20; secondNum++) {
                if (firstNum + secondNum == target){
                    System.out.printf("%d + %d = %d%n", firstNum, secondNum, target);
                } else if (firstNum - secondNum == target) {
                    System.out.printf("%d - %d = %d\n", firstNum, secondNum, target);
                }
            }
        }
    }
}
