package nfs.entities.races.specialRaces;

import nfs.entities.cars.Car;
import nfs.entities.races.Race;
import nfs.utilities.Constants;

import java.util.Map;

public class TimeLimitRace extends Race {

    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);

        this.setGoldTime(goldTime);
    }

    public int getGoldTime() {
        return this.goldTime;
    }

    private void setGoldTime(int goldTime) {
        this.goldTime = goldTime;
    }

    @Override
    public void addParticipant(int carId, Car car) {
        if(this.getParticipants().size() == 0) {
            super.addParticipant(carId, car);
        }
    }

    @Override
    public void start() {
        for (Map.Entry<Integer,Car> participantEntry : this.getParticipants().entrySet()) {
            this.addWinner(participantEntry.getValue());
        }
    }

    private int getTime(Car winner) {
        return this.getLength() * ((winner.getHorsepower() / 100) * winner.getAcceleration());
    }

    private String getTimeClassification(int time) {
        String result = Constants.EMPTY_STRING;

        if(time <= this.getGoldTime()) {
            result = "Gold";
        } else if(time <= this.getGoldTime() + Constants.TIME_LIMIT_RACE_SILVER_TIME_SECONDS_OFFSET) {
            result = "Silver";
        } else if(time > this.getGoldTime() + Constants.TIME_LIMIT_RACE_SILVER_TIME_SECONDS_OFFSET) {
            result = "Bronze";
        }

        return result;
    }

    private int getPlace(String winnerTimeClassification) {
        int place = 0;

        switch (winnerTimeClassification) {
            case "Gold":
                place = 1;
                break;
            case "Silver":
                place = 2;
                break;
            case "Bronze":
                place = 3;
                break;
        }

        return place;
    }

    @Override
    protected String getWinningStats() {
        StringBuilder result = new StringBuilder();

        Car winner = this.getWinners().get(0);
        int winnerTime = this.getTime(winner);
        String winnerTimeClassification = this.getTimeClassification(winnerTime);
        int place = this.getPlace(winnerTimeClassification);
        int prize = this.getPrize(place);

        result.append(String.format("%s %s - %d s.\r\n", winner.getBrand(), winner.getModel(), winnerTime));
        result.append(String.format("%s Time, $%d.", winnerTimeClassification, prize));

        return result.toString();
    }

    @Override
    protected int getPrize(int place) {
        int result = this.getPrizePool();

        if(place == 1) {
            result = (result * Constants.TIME_LIMIT_RACE_FIRST_PLACE_PRIZE_PERCENTAGE) / Constants.MAXIMUM_PERCENTAGE;
        } else if (place == 2) {
            result = (result * Constants.TIME_LIMIT_RACE_SECOND_PLACE_PRIZE_PERCENTAGE) / Constants.MAXIMUM_PERCENTAGE;
        } else if(place == 3) {
            result = (result * Constants.TIME_LIMIT_RACE_THIRD_PLACE_PRIZE_PERCENTAGE) / Constants.MAXIMUM_PERCENTAGE;
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());

        result.append(this.getWinningStats());

        return result.toString();
    }
}
