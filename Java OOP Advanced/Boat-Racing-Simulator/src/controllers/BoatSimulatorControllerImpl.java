package controllers;

import contracts.Raceable;
import models.boats.*;
import utility.Constants;
import contracts.BoatEngine;
import contracts.BoatSimulatorController;
import contracts.Race;
import database.BoatSimulatorDatabase;
import enumeration.EngineType;
import exeptions.*;
import models.engines.JetEngine;
import models.races.RaceImpl;
import models.engines.SterndriveEngine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

public class BoatSimulatorControllerImpl implements BoatSimulatorController {
    private List<Raceable> raceableTimes;
    private BoatSimulatorDatabase database = BoatSimulatorDatabase.getInstance();
    private Race currentRace;

    public BoatSimulatorControllerImpl(BoatSimulatorDatabase database, Race currentRace) {
        this.setDatabase(database);
        this.setCurrentRace(currentRace);
        this.raceableTimes = new ArrayList<>();
    }

    public BoatSimulatorControllerImpl() {
        this.setCurrentRace(null);
        this.raceableTimes = new ArrayList<>();
    }

    public String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {
        BoatEngine engine;
        switch (engineType) {
            case JET:
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case STERNDRIVE:
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


    @Override
    public BoatSimulatorDatabase getDatabase() {
        return this.database;
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

    public String createRowBoat(String model, int weight, boolean isMotorBoat, int oars) throws DuplicateModelException {
        Boat boat = new RowBoat(model, weight, isMotorBoat, oars);
        this.database.getBoats().add(boat);
        return String.format("Row boat with model %s registered successfully.", model);
    }

    public String createSailBoat(String model, int weight, boolean isMotorBoat, int sailEfficiency) throws DuplicateModelException {
        Boat boat = new SailBoat(model, weight, isMotorBoat, sailEfficiency);
        this.database.getBoats().add(boat);
        return String.format("Sail boat with model %s registered successfully.", model);
    }

    public String createPowerBoat(String model, int weight, boolean isMotorBoat, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
        BoatEngine firstEngine = this.database.getEngines().getItem(firstEngineModel);
        BoatEngine secondEngine = this.database.getEngines().getItem(secondEngineModel);
        Boat boat = new PowerBoat(model, weight, isMotorBoat, firstEngine, secondEngine);
        this.database.getBoats().add(boat);
        return String.format("Power boat with model %s registered successfully.", model);
    }

    public String createYacht(String model, int weight, boolean isMotorBoat, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
        BoatEngine engine = this.database.getEngines().getItem(engineModel);
        Boat boat = new Yacht(model, weight, isMotorBoat, engine, cargoWeight);
        this.database.getBoats().add(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        Race race = new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.validateRaceIsEmpty();
        this.currentRace = race;
        return String.format(
                "A new race with distance %s meters, wind speed %sm/s and ocean current speed %s m/s has been set.",
                distance, windSpeed, oceanCurrentSpeed);
    }

    public String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        Boat boat = this.database.getBoats().getItem(model);
        this.validateRaceIsSet();
        if (!this.currentRace.getAllowsMotorboats() && boat.isMotorBoat()) {
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }
        this.currentRace.addParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        this.validateRaceIsSet();
        this.raceableTimes.clear();
        List<Raceable> participants = this.currentRace.getParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.InsufficientContestantsMessage);
        }

        this.setTimes(participants);

        List<Raceable> sortedPositive = this.raceableTimes.stream()
                .filter(e -> e.getRaceTime() > 0.0)
                .sorted((e1, e2) -> Double.compare(e1.getRaceTime(), e2.getRaceTime()))
                .limit(3)
                .collect(Collectors.toList());
        List<Raceable> sortedNegative = new ArrayList<>();
        if (sortedPositive.size() < 3) {
            sortedNegative = this.raceableTimes.stream()
                    .filter(e -> e.getRaceTime() <= 0.0)
                    .limit(3)
                    .collect(Collectors.toList());
        }

        StringBuilder result = new StringBuilder();
        int position = 1;
        for (Raceable boat : sortedPositive) {
            position = getPositionResult(participants, result, position, boat);
        }

        if (sortedPositive.size() < 3) {
            for (Raceable boat : sortedNegative) {
                position = getPositionResult(participants, result, position, boat);
            }
        }

        this.currentRace = null;

        return result.toString().trim();
    }

    private int getPositionResult(List<Raceable> participants, StringBuilder result, int position, Raceable boat) {
        this.appendPosition(result, position);
        result.append(String.format("place: %s Model: %s Time: %s",
                boat.getClass().getSimpleName(),
                boat.getModelName(),
                isFinished(boat.getRaceTime())))
                .append(System.lineSeparator());
        participants.remove(boat);
        position++;
        return position;
    }

    private void appendPosition(StringBuilder result, int position) {
        if (position == 1) {
            result.append("First ");
        } else if (position == 2) {
            result.append("Second ");
        } else {
            result.append("Third ");
        }
    }

    public void setTimes(List<Raceable> participants) {
        for (Raceable participant : participants) {
            double speed = participant.calculateRaceSpeed(this.currentRace);
            double time = this.currentRace.getDistance() / speed;
            participant.setRaceTime(time);
            this.raceableTimes.add(participant);
        }
    }

    private String isFinished(Double key) {
        if (key == Double.NEGATIVE_INFINITY) {
            return "Did not finish!";
        }
        return String.format("%f.2 sec", key);
    }

    @Override
    public String getStatistic() {
        //TODO Bonus Task Implement me
        throw new NotImplementedException();
    }

    private void findFastest(List<Boat> participants) {
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

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RaceAlreadyExistsMessage);
        }
    }
}
