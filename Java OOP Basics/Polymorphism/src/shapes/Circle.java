package shapes;

/**
 * Created by Venelin on 3.3.2017 г..
 */
public class Circle extends Shape{

    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        this.calculateArea();
        this.calculatePerimeter();
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.getRadius());
    }

    @Override
    public void calculateArea() {
        super.setArea(Math.PI * this.getRadius() * this.getRadius());
    }

    private final Double getRadius() {
        return radius;
    }

    private void setRadius(Double radius) {
        this.radius = radius;
    }
}
