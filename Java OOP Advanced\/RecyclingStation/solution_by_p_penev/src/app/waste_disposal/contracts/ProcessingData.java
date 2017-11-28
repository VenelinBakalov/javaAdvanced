package app.waste_disposal.contracts;

/**
 * Interface that ProcessingData objects should implement.
 */
public interface ProcessingData {

    /**
     * Getter function returning the EnergyBalance, a positive number means the process produced energy, while a negative
     * means the process used energy.
     * @return a parameter of type double specifying the amount of energy produced/used.
     */
    double getEnergyBalance();

    /**
     * Getter function returning the CapitalBalance, a positive number means the process produced capital, while a negative
     * means the process used capital.
     * @return a parameter of type double specifying the amount of capital gained/spent.
     */
    double getCapitalBalance();
}
