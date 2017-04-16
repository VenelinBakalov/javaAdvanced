package utility;

public class Constants {


    public static final String INCORRECT_MODEL_LENGTH_MESSAGE = "Model's name must be at least %s symbols long.";

    public static final String INCORRECT_PROPERTY_VALUE_MESSAGE = "%s must be a positive integer.";

    public static final String INCORRECT_SAIL_EFFICIENCY_MESSAGE = "Sail Effectiveness must be between [1...100].";

    public static final String INCORRECT_ENGINE_TYPE_MESSAGE = "Incorrect engine type.";

    public static final String DUPLICATE_MODEL_MESSAGE = "An entry for the given model already exists.";

    public static final String NON_EXISTENT_MODEL_MESSAGE = "The specified model does not exist.";

    public static final String RACE_ALREADY_EXISTS_MESSAGE = "The current race has already been set.";

    public static final String NO_SET_RACE_MESSAGE = "There is currently no race set.";

    public static final String InsufficientContestantsMessage = "Not enough contestants for the race.";

    public static final String INCORRECT_BOAT_TYPE_MESSAGE = "The specified boat does not meet the race constraints.";

    public static final int MIN_BOAT_MODEL_LENGTH = 5;

    public static final int MIN_BOAT_ENGINE_MODEL_LENGTH = 3;

    private Constants() { }
}
