package nfs.entities.races.normalRaces;

import nfs.entities.cars.Car;
import nfs.entities.races.Race;
import nfs.entities.races.normalRaces.NormalRace;
import nfs.utilities.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CircuitRace extends NormalRace {

    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.setLaps(laps);
    }

    @Override
    public int getLength() {
        return super.getLength() * this.getLaps();
    }

    public int getLaps() {
        return this.laps;
    }

    private void setLaps(int laps) {
        this.laps = laps;
    }

    @Override
    public void start() {
        List<Car> participantCars = new ArrayList<Car>();

        for (Map.Entry<Integer,Car> participantEntry : this.getParticipants().entrySet()) {
            participantCars.add(participantEntry.getValue());
        }

        for (int lap = 0; lap < this.getLaps(); lap++) {
            for (Car participant : participantCars) {
                participant.breakDown(super.getLength() * super.getLength());
            }
        }

        int count = 0;

        for(Car car : participantCars
                .stream()
                    .sorted((p1, p2) -> Integer.compare(p2.getOverallPerformance(), p1.getOverallPerformance()))
                .collect(Collectors.toList())) {

            if(count == Constants.CIRCUIT_RACE_MAXIMUM_WINNERS) {
                break;
            }

            this.addWinner(car);
            count++;
        }
    }

    @Override
    protected int getPrize(int place) {
        int prize = this.getPrizePool();

        switch(place) {
            case 1:
                prize = (prize * Constants.CIRCUIT_RACE_FIRST_PLACE_PRIZE_PERCENTAGE) / Constants.MAXIMUM_PERCENTAGE;
                break;
            case 2:
                prize = (prize * Constants.CIRCUIT_RACE_SECOND_PLACE_PRIZE_PERCENTAGE) / Constants.MAXIMUM_PERCENTAGE;
                break;
            case 3:
                prize = (prize * Constants.CIRCUIT_RACE_THIRD_PLACE_PRIZE_PERCENTAGE) / Constants.MAXIMUM_PERCENTAGE;
                break;
            case 4:
                prize = (prize * Constants.CIRCUIT_RACE_FOURTH_PLACE_PRIZE_PERCENTAGE) / Constants.MAXIMUM_PERCENTAGE;
                break;
        }

        return prize;
    }

    @Override
    protected String getWinningStats() {
        StringBuilder result = new StringBuilder();

        int count = 1;

        for (Car car : this.getWinners()) {
            int prize = this.getPrize(count);

            result.append(String.format("%d. %s %s %dPP - $%d\r\n", count, car.getBrand(), car.getModel(), car.getOverallPerformance(), prize));
            count++;
        }

        return result.toString().trim();
    }
}
