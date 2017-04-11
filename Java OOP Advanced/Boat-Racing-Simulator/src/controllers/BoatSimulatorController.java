package controllers;

import Utility.Constants;
import contracts.BoatEngine;
import contracts.IBoatSimulatorController;
import contracts.Race;
import database.BoatSimulatorDatabase;
import enumeration.EngineType;
import exeptions.*;
import models.boats.Boat;
import models.engines.JetEngine;
import models.races.RaceImpl;
import models.engines.SterndriveEngine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class BoatSimulatorController implements IBoatSimulatorController {
    private LinkedHashMap<Double, Boat> map;
    private BoatSimulatorDatabase database;
    private Race currentRace;

    public BoatSimulatorController(BoatSimulatorDatabase database, Race currentRace) {
        this.setDatabase(database);
        this.setCurrentRace(currentRace);
    }

    public BoatSimulatorController() {
        this.setDatabase(new BoatSimulatorDatabase());
        this.setCurrentRace(null);
    }

    @Override
    public BoatSimulatorDatabase getDatabase() {
        return this.database;
    }

    @Override
    public String CreateBoatEngine(String model, int horsepower, int displacement, String engineType) {
        return null;
    }


    public void setDatabase(BoatSimulatorDatabase database) {
        this.database = database;
    }

    @Override
    public Race getCurrentRace() {
        return this.currentRace;
    }

    public void setCurrentRace(Race currentRace) {
        this.currentRace = currentRace;
    }

    public String CreateBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {
        BoatEngine engine;
        switch (engineType) {
            case Jet:
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case Sterndrive:
                engine = new SterndriveEngine(model, horsepower, displacement);
                break;
            default:
                throw new NotImplementedException();
        }

        this.database.getEngines().add(engine);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }

    public String CreateRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Boat boat = new Boat(model, weight, 1, oars, 1, new ArrayList<JetEngine>(), new ArrayList<SterndriveEngine>(), false);
        this.database.getBoats().add(boat);
        return String.format("Row boat with model %s registered successfully.", model);
    }

    public String CreateSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Boat boat = new Boat(model, weight, sailEfficiency, 1, 1, new ArrayList<JetEngine>(), new ArrayList<SterndriveEngine>(), true);
        this.database.getBoats().add(boat);
        return String.format("Sail boat with model %s registered successfully.", model);
    }

    public String CreatePowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
        JetEngine firstEngine = (JetEngine) this.database.getEngines().getItem(firstEngineModel);
        SterndriveEngine secondEngine = (SterndriveEngine) this.database.getEngines().getItem(secondEngineModel);
        Boat boat = new Boat(model, weight, 1, 1, 1, Arrays.asList(firstEngine), Arrays.asList(secondEngine), false);
        this.database.getBoats().add(boat);
        return String.format("Power boat with model %s registered successfully.", model);
    }

    public String CreateYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
        JetEngine engine = (JetEngine) this.database.getEngines().getItem(engineModel);
        Boat boat = new Boat(model, weight, 1, 1, cargoWeight, Arrays.asList(engine), new ArrayList<SterndriveEngine>(), false);
        this.database.getBoats().add(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    public String OpenRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        Race race = new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.ValidateRaceIsEmpty();
        this.currentRace = race;
        return
                String.format(
                        "A new race with distance %s meters, wind speed %sm/s and ocean current speed %s m/s has been set.",
                        distance, windSpeed, oceanCurrentSpeed);
    }

    public String SignUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        Boat boat = this.database.getBoats().getItem(model);
        this.ValidateRaceIsSet();
        if (!this.currentRace.getAllowsMotorboats() && boat instanceof Boat) {
            throw new IllegalArgumentException(Constants.IncorrectBoatTypeMessage);
        }
        this.currentRace.addParticipant(boat);
        return String.format("Boat with model %s has signed up for the current RaceImpl.", model);
    }

    public String StartRace() throws InsufficientContestantsException, NoSetRaceException {
        this.ValidateRaceIsSet();
        List<Boat> participants = this.currentRace.getParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.InsufficientContestantsMessage);
        }


        for (int i = 0; i < 3; i++) {
            FindFastest(participants);
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Double, Boat> doubleMotorBoatEntry : map.entrySet()) {
            result.append(String.format("First place: %s Model: %s Time: %s",
                    doubleMotorBoatEntry.getValue().getClass().getSimpleName().toString(),
                    doubleMotorBoatEntry.getValue().getModelName(),
                    isFinished(doubleMotorBoatEntry.getKey())));
        }

        this.currentRace = null;

        return result.toString();
    }

    private String isFinished(Double key) {
        if (key == Double.NEGATIVE_INFINITY) {
            return "Did not finish!";
        }
        return String.format("%f.2 sec", key);
    }

    @Override
    public String GetStatistic() {
        return null;
    }

    public String getStatistic() {
        //TODO Bonus Task Implement me
        throw new NotImplementedException();
    }

    private void FindFastest(List<Boat> participants) {
        Double bestTime = 0.0;
        Boat winner = null;
        for (Boat participant : participants) {
            Double speed = participant.calculateRaceSpeed(this.currentRace);
            Double time = this.currentRace.getDistance() / speed;
            if (time < bestTime) {
                bestTime = time;
                winner = participant;
            }
        }

        map.put(bestTime, winner);
        participants.remove(winner);
    }

    private void ValidateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }
    }

    private void ValidateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RaceAlreadyExistsMessage);
        }
    }
}
