package nfs.entities.essentials;

import nfs.entities.cars.Car;

import java.util.LinkedHashMap;
import java.util.Map;

public class Garage {
    private Map<Integer, Car> parkedCars;

    public Garage() {
        this.parkedCars = new LinkedHashMap<Integer, Car>();
    }

    public void park(int id, Car car) {
        this.parkedCars.put(id, car);
    }

    public void unpark(int id) {
        this.parkedCars.remove(id);
    }

    public boolean isParked(int id) {
        return this.parkedCars.containsKey(id);
    }

    public void tune(int tuneIndex, String addOn) {
        for (Map.Entry<Integer, Car> car : this.parkedCars.entrySet()) {
            car.getValue().tune(tuneIndex, addOn);
        }
    }
}
