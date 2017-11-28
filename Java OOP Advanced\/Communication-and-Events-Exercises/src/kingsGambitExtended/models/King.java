package kingsGambitExtended.models;

import kingsGambitExtended.abstractions.Attackable;
import kingsGambitExtended.abstractions.BaseUnit;
import kingsGambitExtended.abstractions.Defender;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Venelin on 13.4.2017 г..
 */
public class King extends BaseUnit implements Attackable {

    private Map<String, Defender> defenders;

    public King(String name) {
        super(name);
        this.defenders = new LinkedHashMap<>();
    }

    @Override
    public void addDefender(Defender defender) {
        this.defenders.put(defender.getDefenderName(), defender);
    }

    @Override
    public void killDefender(String defender) {
        this.defenders.remove(defender);
    }

    @Override
    public void respondToAttack() {
        System.out.println(String.format("King %s is under attack!", super.getName()));
        defenders.values().forEach(Defender::respond);
    }

    public Defender getDefender(String name) {
        return this.defenders.get(name);
    }
}
