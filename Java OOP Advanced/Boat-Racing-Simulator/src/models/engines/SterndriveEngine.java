package models.engines;

public class SterndriveEngine extends BoatEngineImpl
{
    private static final int MULTIPLIER = 7;

    public SterndriveEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        return (super.getHorsepower() * MULTIPLIER) + super.getDisplacement();
    }
}
