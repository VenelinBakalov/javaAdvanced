package militaryElite;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Mission implements IMission {

    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        this.setState("Finished");
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state);
    }

    private void setState(String state) {
        if (!"inProgress".equals(state) && !"Finished".equals(state)) {
            throw new IllegalArgumentException("Invalid mission state.");
        }
        this.state = state;
    }
}
