package intersectionOfCircles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 4.7.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstCircleInput = reader.readLine().split("\\s+");
        String[] secondCircleInput = reader.readLine().split("\\s+");

        Point firstCenterPoint = new Point(Integer.parseInt(firstCircleInput[0]), Integer.parseInt(firstCircleInput[1]));
        Circle firstCircle = new Circle(firstCenterPoint, Double.parseDouble(firstCircleInput[2]));

        Point secondCenterPoint = new Point(Integer.parseInt(secondCircleInput[0]), Integer.parseInt(secondCircleInput[1]));
        Circle secondCircle = new Circle(secondCenterPoint, Double.parseDouble(secondCircleInput[2]));

        boolean circlesIntersect = intersect(firstCircle, secondCircle);
        if (circlesIntersect) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean intersect(Circle first, Circle second) {
        double distance = calcDistanceBetweenCenters(first.getCenter(), second.getCenter());
        return distance <= first.getRadius() + second.getRadius();

    }

    private static double calcDistanceBetweenCenters(Point first, Point second) {
        return Math.sqrt(Math.pow((second.getCoordX() - first.getCoordX()), 2) + Math.pow((second.getCoordY() - first.getCoordY()), 2));
    }
}
