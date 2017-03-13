package nfs.entities.races;

import nfs.entities.cars.Car;

import java.util.*;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private Map<Integer, Car> participants;
    private List<Car> winners;

    protected Race(int length, String route, int prizePool) {
        this.setLength(length);
        this.setRoute(route);
        this.setPrizePool(prizePool);

        this.participants = new LinkedHashMap<Integer, Car>();
        this.winners = new ArrayList<Car>();
    }

    public int getLength() {
        return this.length;
    }

    private void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return this.route;
    }

    private void setRoute(String route) {
        this.route = route;
    }

    public int getPrizePool() {
        return this.prizePool;
    }

    private void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    public Map<Integer, Car> getParticipants() {
        return Collections.unmodifiableMap(this.participants);
    }

    public void addParticipant(int carId, Car car) {
        this.participants.put(carId, car);
    }

    public abstract void start();

    protected List<Car> getWinners() {
        return Collections.unmodifiableList(this.winners);
    }

    protected abstract String getWinningStats();

    protected void addWinner(Car winner) {
        this.winners.add(winner);
    }

    protected abstract int getPrize(int place);

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("%s - %d\r\n", this.getRoute(), this.getLength()));

        return result.toString();
    }
}
