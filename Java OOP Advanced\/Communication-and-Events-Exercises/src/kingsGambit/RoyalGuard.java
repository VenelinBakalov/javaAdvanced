package kingsGambit;

/**
 * Created by Venelin on 13.4.2017 г..
 */
public class RoyalGuard extends BaseUnit implements Defender {

    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public void respond() {
        System.out.println(String.format("Royal Guard %s is defending!", super.getName()));
    }

    @Override
    public String getDefenderName() {
        return super.getName();
    }
}
