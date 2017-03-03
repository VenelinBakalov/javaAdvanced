package shapes;

/**
 * Created by Venelin on 3.3.2017 г..
 */
public abstract class Shape {

    private Double perimeter;
    private Double area;

    public Double getPerimeter() {
        return perimeter;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getArea() {
        return area;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public abstract void calculatePerimeter();
    public abstract void calculateArea();
}
