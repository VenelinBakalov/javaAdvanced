package hell.entities.heroes;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public class Barbarian extends BaseHero {

    private static final long BARBARIAN_STRENGTH_DEFAULT_VALUE = 90;
    private static final long BARBARIAN_AGILITY_DEFAULT_VALUE = 25;
    private static final long BARBARIAN_INTELLIGENCE_DEFAULT_VALUE = 10;
    private static final long BARBARIAN_HIT_POINTS_DEFAULT_VALUE = 350;
    private static final long BARBARIAN_DAMAGE_DEFAULT_VALUE = 150;

    public Barbarian(String name) {
        super(name,
                BARBARIAN_STRENGTH_DEFAULT_VALUE,
                BARBARIAN_AGILITY_DEFAULT_VALUE,
                BARBARIAN_INTELLIGENCE_DEFAULT_VALUE,
                BARBARIAN_HIT_POINTS_DEFAULT_VALUE,
                BARBARIAN_DAMAGE_DEFAULT_VALUE
                );
    }
}
