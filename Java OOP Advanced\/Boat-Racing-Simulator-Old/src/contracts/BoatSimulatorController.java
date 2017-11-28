package contracts;

import enumeration.EngineType;
import exeptions.*;

public interface BoatSimulatorController {

    String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException;

    String createRowBoat(String model, int weight, boolean isMotorBoat, int oars) throws DuplicateModelException;

    String createSailBoat(String model, int weight, boolean isMotorBoat, int sailEfficiency) throws DuplicateModelException;

    String createPowerBoat(String model, int weight, boolean isMotorBoat, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException;

    String createYacht(String model, int weight, boolean isMotorBoat, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException;

    String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException;

    String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException;

    String startRace() throws InsufficientContestantsException, NoSetRaceException;

    String getStatistic();
}
