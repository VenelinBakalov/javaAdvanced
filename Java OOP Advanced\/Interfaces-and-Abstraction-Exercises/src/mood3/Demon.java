package mood3;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Demon extends Character<Integer, Double> {

    public Demon(String username, int level, Double specialPoints) {
        super(username, level, specialPoints);
        this.hashPassword();
    }

    @Override
    public Double getSpecialResult() {
        return super.getSpecialPoints() * super.getLevel();
    }

    @Override
    public void hashPassword() {
        super.setHashedPassword(super.getUsername().length() * 217);
    }

    @Override
    public String toString() {
        return super.toString() + this.getSpecialResult();
    }
}
