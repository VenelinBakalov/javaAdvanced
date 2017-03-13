package needForSpeed;

import needForSpeed.models.Garage;
import needForSpeed.models.cars.Car;
import needForSpeed.models.cars.PerformanceCar;
import needForSpeed.models.cars.ShowCar;
import needForSpeed.models.races.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Venelin on 12.3.2017 г..
 */
public class CarManager {

    private static final String AVAILABLE_CAR_STATUS = "available";
    private static final String RACING_CAR_STATUS = "racing";
    private static final String PARKED_CAR_STATUS = "parked";

    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new LinkedHashMap<>();
        this.races = new HashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car car = null;
        switch (type) {
            case "Performance":
                car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            case "Show":
                car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
        }
        if (car != null) {
            cars.put(id, car);
        }
    }

    public String check(int id) {
        return cars.get(id).toString();
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = null;
        switch (type) {
            case "Casual":
                race = new CasualRace(length, route, prizePool);
                break;
            case "Drag":
                race = new DragRace(length, route, prizePool);
                break;
            case "Drift":
                race = new DriftRace(length, route, prizePool);
                break;
        }
        if (race != null) {
            races.put(id, race);
        }
    }

    public void open(int id, String type, int length, String route, int prizePool, int goldTimeOrLaps) {
        Race race = null;
        switch (type) {
            case "TimeLimit":
                race = new TimeLimitRace(length, route, prizePool, goldTimeOrLaps);
                break;
            case "Circuit":
                race = new CircuitRace(length, route, prizePool, goldTimeOrLaps);
                break;
        }
        if (race != null) {
            races.put(id, race);
        }
    }

    public void participate(int carId, int raceId) {
        Car car = cars.get(carId);
        if (!car.getStatus().equals(PARKED_CAR_STATUS)) {
            Race race = this.races.get(raceId);
            race.addCar(car);
        }
    }

    public String start(int id) {
        Race race = this.races.get(id);
        if (race.getParticipants().isEmpty()) {
            return "Cannot start the race with zero participants.";
        }
        race.initiate();
        return race.toString();
    }

    public void park(int id) {
        Car car = this.cars.get(id);
        if (!car.participatesInRace()) {
            this.garage.park(car);
        }
    }

    public void unpark(int id) {
        Car car = this.cars.get(id);
        this.garage.unpark(car);
        car.setAvailableStatus();
    }

    public void tune(int tuneIndex, String addOn) {
        garage.tuneCars(tuneIndex, addOn);
    }

}
