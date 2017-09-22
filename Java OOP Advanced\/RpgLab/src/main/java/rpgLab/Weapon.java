package rpgLab;

/**
 * Created by Dani on 30.3.2017 г..
 */
public interface Weapon {

    int getAttackPoints();

    int getDurabilityPoints();

    void attack(Target target);
}
