package app.waste_disposal.contracts;

/**
 * Interface that Garbage objects should implement. Garbage objects for processing passed to the framework should implement this interface.
 */
public interface Waste {

    /**
     * A getter for the name of the Waste object.
     * @return A string containing the name of the Waste object.
     */
    String getName();

    /**
     * A getter for the garbage's volume per kilogram.
     * @return An object of type double specifying the garbage's volume per kilogram.
     */
    double getVolumePerKg();

    /**
     * A getter for the garbage's weight in kilograms.
     * @return An object of type double specifying the garbage's weight.
     */
    double getWeight();
}
