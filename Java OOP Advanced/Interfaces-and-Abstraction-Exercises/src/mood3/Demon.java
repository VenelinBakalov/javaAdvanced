package mood3;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Demon extends Character {

    private double energy;

    public Demon(String username, int level, double energy) {
        super(username, level);
        this.energy = energy;
    }
}
