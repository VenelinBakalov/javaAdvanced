import java.util.Locale;
import java.util.Scanner;

public class CalculateTriangleArea {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        double area = getTriangleArea(base, height);
        System.out.printf("Area = %.2f", area);
    }

    private static double getTriangleArea(double base, double height){
        return (base * height) / 2;
    }
}
