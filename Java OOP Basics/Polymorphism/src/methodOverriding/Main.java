package methodOverriding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 3.3.2017 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        List<Rectangle> shapes = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] shapeArgs = reader.readLine().split(" ");
            if (shapeArgs.length == 1) {
                Double side = Double.parseDouble(shapeArgs[0]);
                Square square = new Square(side);
                shapes.add(square);
            } else {
                Double sideA = Double.parseDouble(shapeArgs[0]);
                Double sideB = Double.parseDouble(shapeArgs[1]);
                Rectangle rectangle = new Rectangle(sideA, sideB);
                shapes.add(rectangle);
            }
        }

        for (Rectangle shape : shapes) {
            System.out.println(shape.calculateArea());
        }
    }
}
