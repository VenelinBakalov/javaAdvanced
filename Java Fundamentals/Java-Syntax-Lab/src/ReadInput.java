import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.next("\\w+");
        String secondWord = scanner.next("\\w+");

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int thirdNumber = scanner.nextInt();

        scanner.nextLine();

        String thirdWord = scanner.nextLine();

        int sum = firstNumber + secondNumber + thirdNumber;

        System.out.println(firstWord + " " + secondWord + " " + thirdWord + " " + sum);
    }
}
