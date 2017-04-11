package database;

import contracts.Repository;
import models.boats.Boat;
import models.engines.BoatEngineImpl;

public class BoatSimulatorDatabase {

    Repository<Boat> boats;
    Repository<BoatEngineImpl> engines;

    public BoatSimulatorDatabase() {
        this.boats = new RepositoryImpl<>();
        this.engines = new RepositoryImpl<>();
    }

    public Repository<Boat> getBoats() {
        return this.boats;
    }

    public Repository<BoatEngineImpl> getEngines() {
        return this.engines;
    }
}
