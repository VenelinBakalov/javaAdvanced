import java.util.ArrayList;
import java.util.Scanner;

public class ToTheStarsTestsWithArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<double[]> systemsCoordinates = new ArrayList<>();
        String[] systems = new String[3];

        for (int i = 0; i < 3; i++) {
            String[] input = scanner.nextLine().split(" ");
            systems[i] = input[0];
            systemsCoordinates.add(i, new double[] { Double.parseDouble(input[1]), Double.parseDouble(input[2])});
        }

        String[] location = scanner.nextLine().split(" ");
        int moves = Integer.parseInt(scanner.nextLine());

        double currentLocationX = Double.parseDouble(location[0]);
        double currentLocationY = Double.parseDouble(location[1]);

        while (moves >= 0) {

            String currentLocation = "space";

            for (int i = 0; i < systemsCoordinates.size(); i++) {

                double leftEdge = systemsCoordinates.get(i)[0] - 1;
                double rightEdge = systemsCoordinates.get(i)[0] + 1;
                double lowerEdge = systemsCoordinates.get(i)[1] - 1;
                double upperEdge = systemsCoordinates.get(i)[1] + 1;

                if (currentLocationX >= leftEdge && currentLocationX <= rightEdge
                        && currentLocationY >= lowerEdge && currentLocationY <= upperEdge) {
                    currentLocation = systems[i];
                }
            }
            System.out.println(currentLocation.toLowerCase());
            currentLocationY++;
            moves--;
        }
    }
}
