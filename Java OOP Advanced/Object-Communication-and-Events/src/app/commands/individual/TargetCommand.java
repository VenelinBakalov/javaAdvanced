package app.commands.individual;

import app.commands.Command;
import app.models.Attacker;
import app.models.Target;
import app.observer.ObservableTarget;

/**
 * Created by Venelin on 12.4.2017 г..
 */
public class TargetCommand implements Command {

    private Attacker attacker;
    private ObservableTarget target;

    public TargetCommand(Attacker attacker, ObservableTarget target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        attacker.setTarget(target);
    }
}
