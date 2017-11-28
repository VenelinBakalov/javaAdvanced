package shapesDrawing;

/**
 * Created by Venelin on 14.3.2017 г..
 */
public class Circle implements Drawable {

    private int radius;
    private int centerX;
    private int centerY;

    public Circle(int radius, int centerX, int centerY) {
        this.setRadius(radius);
        this.setCenterX(centerX);
        this.setCenterY(centerY);
    }

    @Override
    public void draw() {
        double r_in = this.radius - 0.4;
        double r_out = this.radius + 0.4;

        for (double y = this.radius; y >= -this.radius; --y) {
            for (double x = -this.radius; x <r_out; x += 0.5) {
                double value = x * x + y * y;
                if (value >= r_in * r_in && value <= r_out * r_out) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public int getRadius() {
        return this.radius;
    }

    private void setRadius(int radius) {
        this.radius = radius;
    }

    public int getCenterX() {
        return this.centerX;
    }

    private void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return this.centerY;
    }

    private void setCenterY(int centerY) {
        this.centerY = centerY;
    }
}
