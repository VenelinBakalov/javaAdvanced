package nfs.core;

import nfs.entities.cars.Car;
import nfs.entities.essentials.Garage;
import nfs.entities.races.Race;
import nfs.factories.CarFactory;
import nfs.factories.RaceFactory;
import nfs.utilities.Constants;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static nfs.utilities.Constants.RACE_HAS_NO_PARTICIPANTS_MESSAGE;

public class CarManager {
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;

    private Garage garage;

    public CarManager() {
        this.cars = new LinkedHashMap<Integer, Car>();
        this.races = new LinkedHashMap<Integer, Race>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car newCar = this.makeCar(type, brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);

        this.cars.put(id, newCar);
    }

    public String check(int id) {
        Car foundCar = this.cars.get(id);

        return foundCar.toString();
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        Race newRace = this.makeRace(type, length, route, prizePool);

        this.races.put(id, newRace);
    }

    public void open(int id, String type, int length, String route, int prizePool, int specialRaceParameter) {
        Race newRace = this.makeRace(type, length, route, prizePool, specialRaceParameter);

        this.races.put(id, newRace);
    }

    public void participate(int carId, int raceId) {
        if(!this.isParked(carId)) {
            this.races.get(raceId).addParticipant(carId, this.cars.get(carId));
        }
    }

    public String start(int id) {
        String raceResult = Constants.EMPTY_STRING;

        if(this.races.get(id).getParticipants().size() > 0) {
            Race currentRace = this.races.remove(id);
            currentRace.start();
            raceResult = currentRace.toString();
        }
        else {
            raceResult = Constants.RACE_HAS_NO_PARTICIPANTS_MESSAGE;
        }

        return raceResult;
    }

    public void park(int id) {
        if(!this.isRacer(id)) {
            Car parkedCar = this.cars.get(id);
            this.garage.park(id, parkedCar);
        }
    }

    public void unpark(int id) {
        if(this.isParked(id)) {
            this.garage.unpark(id);
        }
    }

    public void tune(int tuneIndex, String addOn) {
        this.garage.tune(tuneIndex, addOn);
    }

    private Car makeCar(String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car resultCar = null;

        switch(type) {
            case "Performance":
                resultCar = CarFactory.makePerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            case "Show":
                resultCar = CarFactory.makeShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
        }

        return resultCar;
    }

    private Race makeRace(String type, int length, String route, int prizePool) {
        Race resultRace = null;

        switch(type) {
            case "Casual":
                resultRace = RaceFactory.makeCasualRace(length, route, prizePool);
                break;
            case "Drag":
                resultRace = RaceFactory.makeDragRace(length, route, prizePool);
                break;
            case "Drift":
                resultRace = RaceFactory.makeDriftRace(length, route, prizePool);
                break;
        }

        return resultRace;
    }

    private Race makeRace(String type, int length, String route, int prizePool, int specialRaceParameter) {
        Race resultRace = null;

        switch(type) {
            case "TimeLimit":
                resultRace = RaceFactory.makeTimeLimitRace(length, route, prizePool, specialRaceParameter);
                break;
            case "Circuit":
                resultRace = RaceFactory.makeCircuitRace(length, route, prizePool, specialRaceParameter);
                break;
        }

        return resultRace;
    }

    private boolean isRacer(int id) {
        return this.races.entrySet().stream().anyMatch((x) -> x.getValue().getParticipants().containsKey(id));
    }

    private boolean isParked(int id) {
        return this.garage.isParked(id);
    }
}
