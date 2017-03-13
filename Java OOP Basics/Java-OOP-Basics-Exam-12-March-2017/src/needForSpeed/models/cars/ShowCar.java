package needForSpeed.models.cars;

/**
 * Created by Venelin on 12.3.2017 г..
 */
public class ShowCar extends Car {

    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }

    @Override
    public void tune(int tuneIndex, String addOn) {
        super.tune(tuneIndex, addOn);
        this.stars += tuneIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("%d *", this.stars));
        return sb.toString();
    }
}
