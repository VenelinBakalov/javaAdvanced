package rpgLab;

/**
 * Created by Dani on 30.3.2017 г..
 */
public interface Target {
    int getHealth();

    void takeAttack(int attackPoints);

    int giveExperience();

    Weapon dropLoot(RandomProvider random);

    boolean isDead();
}
