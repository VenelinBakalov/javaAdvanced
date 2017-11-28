package kingsGambitExtended.models;

import kingsGambitExtended.abstractions.BaseUnit;
import kingsGambitExtended.abstractions.Defender;

/**
 * Created by Venelin on 13.4.2017 г..
 */
public class Footman extends BaseUnit implements Defender {
    private static final int DEFAULT_HP = 2;

    private int hp;

    public Footman(String name) {
        super(name);
        this.hp = DEFAULT_HP;
    }

    @Override
    public void respond() {
        System.out.println(String.format("Footman %s is panicking!", super.getName()));
    }

    @Override
    public String getDefenderName() {
        return super.getName();
    }

    @Override
    public int getHp() {
        return this.hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }
}
