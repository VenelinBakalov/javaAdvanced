import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();

        double area = getRectangleArea(width, height);
        System.out.printf("%.2f", area);
    }

    private static double getRectangleArea(double width, double height) {
        return width * height;
    }
}
