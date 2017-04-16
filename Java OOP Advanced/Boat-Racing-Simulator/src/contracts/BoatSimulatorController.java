package contracts;

import exeptions.*;
import models.boats.Boat;

public interface BoatSimulatorController {

    String create(Boat boat) throws DuplicateModelException;

    String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException;

    String signUpBoat(Boat boat) throws NonExistantModelException, DuplicateModelException, NoSetRaceException;

    String startRace() throws InsufficientContestantsException, NoSetRaceException;

    String getStatistic();
}
