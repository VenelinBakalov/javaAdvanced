package kingsGambit;

/**
 * Created by Venelin on 13.4.2017 г..
 */
public class Footman extends BaseUnit implements Defender {

    public Footman(String name) {
        super(name);
    }

    @Override
    public void respond() {
        System.out.println(String.format("Footman %s is panicking!", super.getName()));
    }

    @Override
    public String getDefenderName() {
        return super.getName();
    }
}
