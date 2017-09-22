package database;

import contracts.BoatEngine;
import contracts.Repository;
import models.boats.Boat;

public class BoatSimulatorDatabase {

    private static final BoatSimulatorDatabase INSTANCE = new BoatSimulatorDatabase();

    private Repository<Boat> boats;
    private Repository<BoatEngine> engines;

    private BoatSimulatorDatabase() {
        this.boats = new RepositoryImpl<>();
        this.engines = new RepositoryImpl<>();
    }

    public static BoatSimulatorDatabase getInstance() {
        return INSTANCE;
    }

    public Repository<Boat> getBoats() {
        return this.boats;
    }

    public Repository<BoatEngine> getEngines() {
        return this.engines;
    }
}
