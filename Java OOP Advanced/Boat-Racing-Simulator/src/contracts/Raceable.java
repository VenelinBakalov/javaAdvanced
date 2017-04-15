package contracts;

public interface Raceable extends Modelable {

    double calculateRaceSpeed(Race race);

    double getRaceTime();

    void setRaceTime(double time);
}
