package infernoInfinity;

import java.util.ArrayList;

/**
 * Created by Venelin on 24.3.2017 г..
 */
public class Weapon {

    private String name;
    private WeaponType type;
    private GemType[] gems;

    private int minDamage;
    private int maxDamage;
    private int strength;
    private int agility;
    private int vitality;

    public Weapon(String name, WeaponType type) {
        this.name = name;
        this.type = type;
        this.gems = new GemType[type.getSocketsCount()];
        this.minDamage = 0;
        this.maxDamage = 0;
        this.strength = 0;
        this.agility = 0;
        this.vitality = 0;
    }

    public void addGem(int index, GemType type) {
        if (index < 0 || this.gems.length >= index) {
            throw new IllegalArgumentException("Hakuna Matata! What a wonderful phrase!");
        }
        this.gems[index] = type;
    }

    public void removeGem(int index) {
        if (index < 0 || this.gems.length >= index) {
            throw new IllegalArgumentException("Hakuna Matata! Ain't no passing craaaaze!");
        }
        this.gems[index] = null;
    }
}
