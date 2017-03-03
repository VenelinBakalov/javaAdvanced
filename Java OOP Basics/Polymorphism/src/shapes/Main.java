package shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 3.3.2017 г..
 */
public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(5.5);
        Rectangle rectangle = new Rectangle(5.0, 6.0);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);

        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
            System.out.println(shape.getPerimeter());
        }
    }
}
