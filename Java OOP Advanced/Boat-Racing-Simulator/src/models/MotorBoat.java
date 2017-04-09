package models;

import Utility.Constants;
import Utility.Validator;
import contracts.IModelable;
import contracts.IRace;

import java.util.List;

public final class MotorBoat implements IModelable {
    private String model;
    private List<SterndriveEngine> sterndriveEngines;
    public Boolean isSailboat;

    public MotorBoat(String model, int weight, int sailEfficiency, int oars, int cargoWeight, List<JetEngine> jetEngines, List<SterndriveEngine> sterndriveEngines, Boolean isSailboat) {
        this.model = model;
        this.sterndriveEngines = sterndriveEngines;
        this.isSailboat = isSailboat;
    }

    @Override
    public String getModel() {
        return model;
    }

    public List<SterndriveEngine> getSterndriveEngines() {
        return sterndriveEngines;
    }

    public void setSterndriveEngines(List<SterndriveEngine> sterndriveEngines) {
        this.sterndriveEngines = sterndriveEngines;
    }

    public double CalculateRaceSpeed(IRace race) {
        //if (this.getJetEngines().size() + this.getSterndriveEngines().size() == 2) {
        //    var speed = this.JetEngines.Sum(x = > x.Output)+this.SterndriveEngines.Sum(x = > x.Output)
        //    -this.Weight + (race.OceanCurrentSpeed / 5d);
        //    return speed;
        //} else if (this.getJetEngines().size() + this.getSterndriveEngines().size() == 1) {
        //    var speed = this.JetEngines.Sum(x = > x.Output)+this.SterndriveEngines.Sum(x = > x.Output)
        //    -this.Weight - this.CargoWeight + (race.OceanCurrentSpeed / 2d);
        //    return speed;
        //} else if (isSailboat) {
        //    var speed = (race.WindSpeed * (this.SailEfficiency / 100d)) - this.Weight + (race.OceanCurrentSpeed / 2d);
        //    return speed;
        //} else {
        //    var speed = (this.Oars * 100) - this.Weight + race.OceanCurrentSpeed;
        //    return speed;
        //}
        return 0;
    }
}


