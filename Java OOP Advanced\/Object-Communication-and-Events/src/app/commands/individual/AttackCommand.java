package app.commands.individual;

import app.commands.Command;
import app.models.Attacker;

/**
 * Created by Venelin on 12.4.2017 г..
 */
public class AttackCommand implements Command {

    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        attacker.attack();
    }
}
