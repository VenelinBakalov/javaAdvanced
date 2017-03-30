package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpgLab.Axe;
import rpgLab.Dummy;
import rpgLab.Target;
import rpgLab.Weapon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Venelin on 30.3.2017 г..
 */
public class AxeTests {

    public static final int AXE_ATTACK = 10;
    public static final int AXE_DURABILITY = 10;
    public static final int DUMMY_HEALTH = 10;
    public static final int DUMMY_XP = 10;
    public static final int EXPECTED_DURABILITY = 9;
    public static final String WRONG_DURABILITY_ERROR_MESSAGE = "Wrong durability";

    private List<Weapon> weapons;

    private Weapon axe;
    private Target target;

    @Before
    public void initializeTestObjects() {
        this.weapons = new ArrayList<Weapon>();
        Collections.addAll(this.weapons, new Axe(20, 20), new Axe(30, 30));
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.target = new Dummy(DUMMY_HEALTH, DUMMY_XP, new ArrayList<Weapon>());
    }

    @Test
    public void weaponLosesDurabilityAfterAttack() {
        // arrange
        // act
        this.axe.attack(target);

        // assert
        Assert.assertEquals(WRONG_DURABILITY_ERROR_MESSAGE, EXPECTED_DURABILITY, this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {
        while (this.axe.getDurabilityPoints() > 0) {
            this.axe.attack(target);
        }
        axe.attack(target);
    }
}
