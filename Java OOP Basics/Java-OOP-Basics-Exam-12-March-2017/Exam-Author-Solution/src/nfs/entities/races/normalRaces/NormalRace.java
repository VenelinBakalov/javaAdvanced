package nfs.entities.races.normalRaces;

import nfs.entities.cars.Car;
import nfs.entities.races.Race;
import nfs.utilities.Constants;

public abstract class NormalRace extends Race{

    protected NormalRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    protected int getPrize(int place) {
        int prize = this.getPrizePool();

        switch(place) {
            case 1:
                prize = (prize * Constants.NORMAL_RACE_FIRST_PLACE_PRIZE_PERCENTAGE) / Constants.MAXIMUM_PERCENTAGE;
                break;
            case 2:
                prize = (prize * Constants.NORMAL_RACE_SECOND_PLACE_PRIZE_PERCENTAGE) / Constants.MAXIMUM_PERCENTAGE;
                break;
            case 3:
                prize = (prize * Constants.NORMAL_RACE_THIRD_PLACE_PRIZE_PERCENTAGE) / Constants.MAXIMUM_PERCENTAGE;
                break;
        }

        return prize;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());

        result.append(this.getWinningStats());

        return result.toString();
    }
}
