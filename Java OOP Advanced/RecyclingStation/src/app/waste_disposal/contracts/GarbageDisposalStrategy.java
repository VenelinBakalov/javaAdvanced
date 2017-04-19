package app.waste_disposal.contracts;

/**
 * Interface that Garbage Disposal Strategies passed to the Waste Disposal Framework should implement.
 */
public interface GarbageDisposalStrategy {

    /**
     * Processes a Waste object and returns the result of the processing as a ProcessingData object.
     * @param garbage The Waste object that will be processed.
     * @return An object of type ProcessingData containing all information about the results of the processing.
     */
    ProcessingData processGarbage(Waste garbage);
}
