package hell.entities.heroes;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public class Wizard extends BaseHero {

    private static final long WIZARD_STRENGTH_DEFAULT_VALUE = 25;
    private static final long WIZARD_AGILITY_DEFAULT_VALUE = 25;
    private static final long WIZARD_INTELLIGENCE_DEFAULT_VALUE = 100;
    private static final long WIZARD_HIT_POINTS_DEFAULT_VALUE = 100;
    private static final long WIZARD_DAMAGE_DEFAULT_VALUE = 250;

    public Wizard(String name) {
        super(name,
                WIZARD_STRENGTH_DEFAULT_VALUE,
                WIZARD_AGILITY_DEFAULT_VALUE,
                WIZARD_INTELLIGENCE_DEFAULT_VALUE,
                WIZARD_HIT_POINTS_DEFAULT_VALUE,
                WIZARD_DAMAGE_DEFAULT_VALUE
                );
    }
}
