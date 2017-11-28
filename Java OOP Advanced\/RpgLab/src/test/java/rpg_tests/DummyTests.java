package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpgLab.Dummy;
import rpgLab.Target;
import rpgLab.Weapon;

import java.util.ArrayList;

/**
 * Created by Venelin on 30.3.2017 г..
 */
public class DummyTests {

    private static final int HEALTH = 10;
    private static final int EXPERIENCE = 10;
    private static final int ATTACK_POINTS = 10;
    private static final String WRONG_HEALTH_ERROR_MESSAGE = "Wrong health";

    private Target target;

    @Before
    public void createDummy() {
       this.target = new Dummy(HEALTH, EXPERIENCE, new ArrayList<Weapon>());
    }

    @Test
    public void testDummyHealthWhenAttacked() {
        target.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(
                WRONG_HEALTH_ERROR_MESSAGE,
                HEALTH - ATTACK_POINTS,
                this.target.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyWhenAttacked() {
        target.takeAttack(ATTACK_POINTS);
        target.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDeadDummyGivesXPWhenKilled() {
        target.takeAttack(ATTACK_POINTS);
        Assert.assertEquals("Wrong experience", EXPERIENCE, target.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyNotGiveXp() {
        target.giveExperience();
    }
}
