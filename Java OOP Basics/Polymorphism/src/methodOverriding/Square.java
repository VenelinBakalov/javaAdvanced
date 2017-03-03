package methodOverriding;

/**
 * Created by Venelin on 3.3.2017 г..
 */
public class Square extends Rectangle{

    public Square(Double side) {
        super(side);
    }

    @Override
    public Double calculateArea() {
        return this.getSideA() * this.getSideA();
    }
}
