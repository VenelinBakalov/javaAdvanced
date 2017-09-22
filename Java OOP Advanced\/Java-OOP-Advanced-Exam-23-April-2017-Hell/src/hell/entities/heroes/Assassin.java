package hell.entities.heroes;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public class Assassin extends BaseHero {

    private static final long ASSASSIN_STRENGTH_DEFAULT_VALUE = 25;
    private static final long ASSASSIN_AGILITY_DEFAULT_VALUE = 100;
    private static final long ASSASSIN_INTELLIGENCE_DEFAULT_VALUE = 15;
    private static final long ASSASSIN_HIT_POINTS_DEFAULT_VALUE = 150;
    private static final long ASSASSIN_DAMAGE_DEFAULT_VALUE = 300;

    public Assassin(String name) {
        super(name,
                ASSASSIN_STRENGTH_DEFAULT_VALUE,
                ASSASSIN_AGILITY_DEFAULT_VALUE,
                ASSASSIN_INTELLIGENCE_DEFAULT_VALUE,
                ASSASSIN_HIT_POINTS_DEFAULT_VALUE,
                ASSASSIN_DAMAGE_DEFAULT_VALUE
                );
    }
}
