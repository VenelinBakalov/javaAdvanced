package nfs.entities.races.normalRaces;

import nfs.entities.cars.Car;
import nfs.utilities.Constants;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DriftRace extends NormalRace {
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public void start() {
        int count = 0;

        LinkedHashMap<Integer, Car> orderedParticipants = this.getParticipants()
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getSuspensionPerformance(), e1.getValue().getSuspensionPerformance()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x1, x2) -> {throw new AssertionError();},
                        LinkedHashMap::new
                ));

        for (Map.Entry<Integer,Car> winner : orderedParticipants.entrySet()) {

            if (count == Constants.DRIFT_RACE_MAXIMUM_WINNERS) {
                break;
            }

            this.addWinner(winner.getValue());
            count++;
        }
    }

    @Override
    protected String getWinningStats() {
        StringBuilder result = new StringBuilder();

        int count = 1;

        for (Car car : this.getWinners()) {
            int prize = this.getPrize(count);

            result.append(String.format("%d. %s %s %dPP - $%d\r\n", count, car.getBrand(), car.getModel(), car.getSuspensionPerformance(), prize));
            count++;
        }

        return result.toString().trim();
    }
}
