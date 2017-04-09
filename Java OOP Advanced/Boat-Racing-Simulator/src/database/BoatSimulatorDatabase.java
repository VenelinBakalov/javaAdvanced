package database;

import contracts.IModelable;
import contracts.IRepository;
import models.MotorBoat;

public class BoatSimulatorDatabase {
    IRepository<MotorBoat> boats;
    IRepository<IModelable> engines;

    public BoatSimulatorDatabase()
    {
        this.setBoats(new Repository<MotorBoat>());
        this.setEngines(new Repository<IModelable>());
    }

    public IRepository<MotorBoat> getBoats() {
        return this.boats;
    }

    private void setBoats(IRepository<MotorBoat> boats) {
        this.boats = boats;
    }

    public IRepository<IModelable> getEngines() {
        return this.engines;
    }

    private void setEngines(IRepository<IModelable> engines) {
        this.engines = engines;
    }
}
