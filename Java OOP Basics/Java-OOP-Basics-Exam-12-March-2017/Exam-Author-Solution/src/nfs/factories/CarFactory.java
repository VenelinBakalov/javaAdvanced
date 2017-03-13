package nfs.factories;

import nfs.entities.cars.PerformanceCar;
import nfs.entities.cars.ShowCar;

public final class CarFactory {

    private CarFactory() {}

    public static PerformanceCar makePerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        return new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }

    public static ShowCar makeShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        return new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }
}
