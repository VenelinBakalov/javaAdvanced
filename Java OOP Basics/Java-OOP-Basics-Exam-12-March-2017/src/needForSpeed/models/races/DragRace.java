package needForSpeed.models.races;


/**
 * Created by Venelin on 12.3.2017 г..
 */
public class DragRace extends Race {


    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public void calculateParticipantsPerformancePoints() {
        super.getParticipants().forEach(c -> c.setPerformancePoints(c.getEnginePerformance()));
    }
}
