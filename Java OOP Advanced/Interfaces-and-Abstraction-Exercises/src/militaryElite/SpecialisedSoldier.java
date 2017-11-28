package militaryElite;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public abstract class SpecialisedSoldier extends Private implements ISpecialisedSoldier {

    private String corps;

    protected SpecialisedSoldier(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    private void setCorps(String corps) {
        if (!"Airforces".equals(corps) && !"Marines".equals(corps)) {
            throw new IllegalArgumentException("Invalid corps!");
        }
        this.corps = corps;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + "Corps: " + this.corps;
    }
}
