package needForSpeed.models.races;

import needForSpeed.models.cars.Car;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 12.3.2017 г..
 */
public class CircuitRace extends Race {

    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    @Override
    public void calculateParticipantsPerformancePoints() {
        super.getParticipants().forEach(c -> c.setDurability(c.getDurability() - (this.laps * super.getLength() * super.getLength())));
        super.getParticipants().forEach(c -> c.setPerformancePoints(c.getOverallPerformance())
        );
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getRoute() + " - " + super.getLength() * this.laps).append(System.lineSeparator());
        sb.append(getParticipantStatus(1));
        if (this.getWinners().size() > 1) {
            sb.append(System.lineSeparator()).append(getParticipantStatus(2));
            if (this.getWinners().size() > 2) {
                sb.append(System.lineSeparator()).append(getParticipantStatus(3));
                if (this.getWinners().size() > 3) {
                    sb.append(System.lineSeparator()).append(getParticipantStatus(4));
                }
            }
        }
        return sb.toString();
    }

    @Override
    protected String getParticipantStatus(int position) {
        Car participant = this.getWinners().get(position - 1);
        return String.format("%d. %s %s %dPP - $%d", position, participant.getBrand(), participant.getModel(),
                participant.getPerformancePoints(), getPrize(position));
    }

    @Override
    protected List<Car> getWinners() {
        return this.getParticipants().stream()
                .sorted((c1, c2) -> Integer.compare(c2.getPerformancePoints(), c1.getPerformancePoints()))
                .limit(4)
                .collect(Collectors.toList());
    }

    @Override
    protected int getPrize(int position) {
        switch (position) {
            case 1:
                return (super.getPrizePool() * 40) / 100;
            case 2:
                return (super.getPrizePool() * 30) / 100;
            case 3:
                return (super.getPrizePool() * 20) / 100;
            case 4:
                return (super.getPrizePool() * 10) / 100;
            default:
                return 0;
        }
    }
}
