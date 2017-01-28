package states;


public class StateManager {
    private static State currentState;

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State currentState) {
        currentState = currentState;
    }
}
