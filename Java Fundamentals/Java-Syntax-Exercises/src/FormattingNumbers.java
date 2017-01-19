import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split("\\s+");

        int firstNum = Integer.parseInt(inputLine[0]);
        double secondNum = Double.parseDouble(inputLine[1]);
        double thirdNum = Double.parseDouble(inputLine[2]);

        String binary = String.format("%10s", Integer.toBinaryString(firstNum)).replace(' ', '0');

        System.out.printf("|%-10s|", Integer.toHexString(firstNum).toUpperCase());
        System.out.printf("%s|", binary);
        System.out.printf("%10.2f|", secondNum);
        System.out.printf("%-10.3f|", thirdNum);
  //    System.out.printf("|%-10s|%10s|%10.2f|%-10.3f|", Integer.toHexString(firstNum), Integer.toBinaryString(firstNum), secondNum, thirdNum);
    }
}
