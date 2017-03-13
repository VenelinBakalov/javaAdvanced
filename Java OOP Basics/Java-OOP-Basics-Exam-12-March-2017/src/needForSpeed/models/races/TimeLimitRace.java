package needForSpeed.models.races;

import needForSpeed.models.cars.Car;

/**
 * Created by Venelin on 12.3.2017 г..
 */
public class TimeLimitRace extends Race {

    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    @Override
    public void addCar(Car car) {
        if (super.getParticipants().size() < 1) {
            super.addCar(car);
        }
    }

    @Override
    public void calculateParticipantsPerformancePoints() {
        super.getParticipants()
                .forEach(c -> c.setPerformancePoints(super.getLength() * ((c.getHorsepower() / 100) * c.getAcceleration())));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getRoute() + " - " + super.getLength()).append(System.lineSeparator());
        sb.append(getParticipantResult());
        sb.append(String.format("%s Time, $%d.", getParticipantTimeClassification(), getWonPrize()));
        return sb.toString();
    }

    public String getParticipantResult() {
        Car participant = super.getParticipants().stream().findFirst().get();
        return String.format("%s %s - %d s.%n", participant.getBrand(), participant.getModel(), participant.getPerformancePoints());
    }

    public String getParticipantTimeClassification() {
        Car participant = super.getParticipants().stream().findFirst().get();
        if (participant.getPerformancePoints() <= this.goldTime) {
            return "Gold";
        } else if (participant.getPerformancePoints() <= this.goldTime + 15) {
            return "Silver";
        }
        return "Bronze";
    }

    public int getWonPrize() {
        String timeClassification = this.getParticipantTimeClassification();
        switch (timeClassification) {
            case "Gold":
                return super.getPrizePool();
            case "Silver":
                return (super.getPrizePool() * 50) / 100;
            case "Bronze":
                return (super.getPrizePool() * 30) / 100;
            default:
                return 0;
        }
    }
}
