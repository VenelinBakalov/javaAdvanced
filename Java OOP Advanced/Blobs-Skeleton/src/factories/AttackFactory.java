package factories;

import interfaces.Attack;

/**
 * Created by Venelin on 8.4.2017 г..
 */
public class AttackFactory {
    private static final String ATTACKS_PACKAGE = "models.attacks.";

    public Attack createAttack(String attackType) throws ReflectiveOperationException {
        Class<Attack> attackClass = (Class<Attack>) Class.forName(ATTACKS_PACKAGE + attackType);
        return attackClass.newInstance();
    }
}
