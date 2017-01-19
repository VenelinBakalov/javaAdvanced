import java.util.Scanner;

public class CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split("\\s+");

        double firstNum = Double.parseDouble(inputLine[0]);
        double secondNum = Double.parseDouble(inputLine[1]);
        double thirdNum = Double.parseDouble(inputLine[2]);

        double firstFormulaResult = Math.pow((Math.pow(firstNum, 2) + Math.pow(secondNum, 2)) / (Math.pow(firstNum, 2) - Math.pow(secondNum, 2))
                , (firstNum + secondNum + thirdNum) / Math.sqrt(thirdNum));

        double secondFormulaResult = Math.pow(Math.pow(firstNum, 2) + Math.pow(secondNum, 2) - Math.pow(thirdNum, 3), (firstNum - secondNum));

        double difference = Math.abs(((firstNum + secondNum + thirdNum) / 3) - ((firstFormulaResult + secondFormulaResult) / 2));

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", firstFormulaResult, secondFormulaResult, difference);
    }
}
