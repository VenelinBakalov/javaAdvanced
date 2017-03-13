package needForSpeed.models;

import needForSpeed.models.cars.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 12.3.2017 г..
 */
public class Garage {

    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public void park(Car car) {
        car.setParkedStatus();
        this.parkedCars.add(car);
    }

    public void unpark(Car car) {
        this.parkedCars.remove(car);
    }

    public void tuneCars(int tuneIndex, String addOn) {
        this.parkedCars.forEach(c -> c.tune(tuneIndex, addOn));
    }
}
