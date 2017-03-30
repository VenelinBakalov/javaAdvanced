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

    public static final int WEAPON_DURABILITY = 10;
    public static final int WEAPON_ATTACK = 10;
    public static final int TARGET_XP = 10;

    private Hero hero;
    private Weapon weaponMock;
    private Target targetMock;
    private RandomProvider randomMock;

    @Before
    public void initializeTestObjects() {
        this.weaponMock = Mockito.mock(Weapon.class);
        this.hero = new Hero("Hero", weaponMock);
        this.targetMock = Mockito.mock(Target.class);
        this.randomMock = Mockito.mock(RandomProvider.class);

    }

    @Test
    public void heroGainsExperienceFromDeadTarget() {
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        hero.attack(targetMock, new RandomProvider.Implementation());
        Assert.assertEquals(TARGET_XP, hero.getExperience());
    }

    @Test
    public void heroGetsWeaponWhenTargetIsDead() {
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveWeapon(this.randomMock)).thenReturn(this.weaponMock);

        this.hero.attack(this.targetMock, this.randomMock);

        Assert.assertSame(this.weaponMock, this.hero.getInventory().iterator().next());
    }
}
