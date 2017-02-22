package rawData;


import java.util.Set;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Set<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, Set<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Set<Tire> getTires() {
        return tires;
    }

    @Override
    public String toString(){
        return this.model;
    }
}
