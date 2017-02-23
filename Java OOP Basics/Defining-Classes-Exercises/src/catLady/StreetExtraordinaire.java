package catLady;


public class StreetExtraordinaire extends Cat{

    private int decibelsOfMeows;

    public StreetExtraordinaire(String name, int decibelsOfMeows) {
        super(name, "StreetExtraordinaire");
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", super.getType(), super.getName(), this.decibelsOfMeows);
    }
}
