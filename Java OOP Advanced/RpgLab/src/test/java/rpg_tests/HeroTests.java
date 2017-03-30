package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpgLab.*;

/**
 * Created by Venelin on 30.3.2017 г..
 */
public class HeroTests {

    private static final int WEAPON_ATTACK = 10;
    private static final int TARGET_XP = 10;
    private static final String HERO_TEST_NAME = "Hero";
    private static final String WRONG_EXPERIENCE_ERROR_MESSAGE = "Wrong experience";

    private Hero hero;
    private Weapon weaponMock;
    private Target targetMock;
    private RandomProvider randomMock;

    @Before
    public void initializeTestObjects() {
        this.weaponMock = Mockito.mock(Weapon.class);
        this.targetMock = Mockito.mock(Target.class);
        this.randomMock = Mockito.mock(RandomProvider.class);
        this.hero = new Hero(HERO_TEST_NAME, weaponMock);
    }

    @Test
    public void heroGainsExperienceAfterAttackIfTargetDies() {
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        hero.attack(targetMock, new RandomProvider.Implementation());
        Assert.assertEquals(WRONG_EXPERIENCE_ERROR_MESSAGE, TARGET_XP, hero.getExperience());
    }

    @Test
    public void heroGetsWeaponWhenTargetIsDead() {
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.dropLoot(this.randomMock)).thenReturn(this.weaponMock);

        this.hero.attack(this.targetMock, this.randomMock);

        Assert.assertSame(this.weaponMock, this.hero.getInventory().iterator().next());
    }

    @Test
    public void oldTestForExperienceGain() {
        Target fakeTarget = new Target() {
            public int getHealth() {
                return 0;
            }
            public void takeAttack(int attackPoints) {
            }
            public int giveExperience() {
                return TARGET_XP;
            }
            public Weapon dropLoot(RandomProvider random) {
                return null;
            }
            public boolean isDead() {
                return true;
            }
        };

        Weapon fakeWeapon = new Weapon() {
            public int getAttackPoints() {
                return WEAPON_ATTACK;
            }
            public int getDurabilityPoints() {
                return 0;
            }
            public void attack(Target target) {
            }
        };

        Hero hero = new Hero(HERO_TEST_NAME, fakeWeapon);
        hero.attack(fakeTarget, new RandomProvider.Implementation());
        Assert.assertEquals(TARGET_XP, hero.getExperience());
    }
}
