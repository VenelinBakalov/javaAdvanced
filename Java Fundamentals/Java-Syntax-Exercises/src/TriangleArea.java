import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputPointA = scanner.nextLine().split(" ");
        String[] inputPointB = scanner.nextLine().split(" ");
        String[] inputPointC = scanner.nextLine().split(" ");

        int[] pointA = new int[2];
        pointA[0] = Integer.parseInt(inputPointA[0]);
        pointA[1] = Integer.parseInt(inputPointA[1]);

        int[] pointB = new int[2];
        pointB[0] = Integer.parseInt(inputPointB[0]);
        pointB[1] = Integer.parseInt(inputPointB[1]);

        int[] pointC = new int[2];
        pointC[0] = Integer.parseInt(inputPointC[0]);
        pointC[1] = Integer.parseInt(inputPointC[1]);

        double area = getTriangleArea(pointA, pointB, pointC);

        System.out.printf("%d", (int)area);
    }

    private static double getTriangleArea(int[] pointA, int[] pointB, int[] pointC) {
        int area = Math.abs((pointA[0] * (pointB[1] - pointC[1]) + pointB[0] * (pointC[1] - pointA[1])
                    + pointC[0] * (pointA[1] - pointB[1])) / 2);

        return area;
    }
}
