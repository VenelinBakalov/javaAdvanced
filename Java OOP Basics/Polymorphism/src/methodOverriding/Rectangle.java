package methodOverriding;

/**
 * Created by Venelin on 3.3.2017 г..
 */

public class Rectangle {

    private Double sideA;
    private Double sideB;

    public Rectangle(Double sideA, Double sideB) {
        this.setSideA(sideA);
        this.setSideB(sideB);
    }

    public Rectangle(Double side) {
        this.setSideA(side);
    }

    public Double calculateArea() {
        return this.getSideA() * this.getSideB();
    }

    protected Double getSideA() {
        return sideA;
    }

    private Double getSideB() {
        return sideB;
    }

    private void setSideA(Double sideA) {
        this.sideA = sideA;
    }

    private void setSideB(Double sideB) {
        this.sideB = sideB;
    }
}
