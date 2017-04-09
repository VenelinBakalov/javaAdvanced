package contracts;

import exeptions.*;

import java.util.List;

public interface ICommandHandler {
    String ExecuteCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException;
}
