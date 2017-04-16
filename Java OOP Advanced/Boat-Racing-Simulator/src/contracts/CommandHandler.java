package contracts;

import exeptions.*;

public interface CommandHandler {
    String executeCommand(String name, String... parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException;
}
