package Utility;

public class Constants {


    public static final String INCORRECT_MODEL_LENGTH_MESSAGE = "Model's name must be at least %s symbols long.";

    public static final String INCORRECT_PROPERTY_VALUE_MESSAGE = "%s must be a positive integer.";

    public static final String INCORRECT_SAIL_EFFICIANCY_MESSAGE = "Sail Effectiveness must be between [1...100].";

    public static final String IncorrectEngineTypeMessage = "Incorrect engine type.";

    public static final String DuplicateModelMessage = "An entry for the given model already exists.";

    public static final String NonExistantModelMessage = "The specified model does not exist.";

    public static final String RaceAlreadyExistsMessage = "The current race has already been set.";

    public static final String NoSetRaceMessage = "There is currently no race set.";

    public static final String InsufficientContestantsMessage = "Not enough contestants for the race.";

    public static final String IncorrectBoatTypeMessage = "The specified boat does not meet the race constraints.";

    public static final int MIN_BOAT_MODEL_LENGTH = 5;

    public static final int MIN_BOAT_ENGINE_MODEL_LENGTH = 3;

    private Constants() { }
}
