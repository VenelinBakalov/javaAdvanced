package needForSpeed.models.races;

import needForSpeed.models.cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 12.3.2017 г..
 */
public abstract class Race {
    private static final String DEFAULT_RACE_STATUS = "open";
    private static final String CLOSED_RACE_STATUS = "closed";

    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;
    private String raceStatus;
    private List<Car> winners;

    protected Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
        this.raceStatus = DEFAULT_RACE_STATUS;
        this.winners = new ArrayList<>();
    }

    public abstract void calculateParticipantsPerformancePoints();

    public void addCar(Car car) {
        if (this.raceStatus.equals(DEFAULT_RACE_STATUS)) {
            car.participate(this.route);
            this.participants.add(car);
        }
    }

    public void initiate() {
        this.calculateParticipantsPerformancePoints();
        this.participants.forEach(c -> c.finishRace(this.route));
        this.winners = getWinners();
        this.raceStatus = CLOSED_RACE_STATUS;
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(participants);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.route + " - " + this.length).append(System.lineSeparator());
        sb.append(getParticipantStatus(1));
        if (this.winners.size() > 1) {
            sb.append(System.lineSeparator()).append(getParticipantStatus(2));
            if (this.winners.size() > 2) {
                sb.append(System.lineSeparator()).append(getParticipantStatus(3));
            }
        }
        return sb.toString();
    }

    protected int getLength() {
        return length;
    }

    protected String getRoute() {
        return route;
    }

    protected int getPrizePool() {
        return prizePool;
    }

    protected String getParticipantStatus(int position) {
        Car participant = this.winners.get(position - 1);
        return String.format("%d. %s %s %dPP - $%d", position, participant.getBrand(), participant.getModel(),
                participant.getPerformancePoints(), getPrize(position));
    }

    protected List<Car> getWinners() {
        return this.participants.stream()
                .sorted((c1, c2) -> Integer.compare(c2.getPerformancePoints(), c1.getPerformancePoints()))
                .limit(3)
                .collect(Collectors.toList());
    }

    protected int getPrize(int position) {
        switch (position) {
            case 1:
                return (this.prizePool * 50) / 100;
            case 2:
                return (this.prizePool * 30) / 100;
            case 3:
                return (this.prizePool * 20) / 100;
            default:
                return 0;
        }
    }


}
