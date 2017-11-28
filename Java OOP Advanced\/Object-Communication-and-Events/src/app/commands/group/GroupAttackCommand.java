package app.commands.group;

import app.commands.Command;
import app.mediator.AttackGroup;

/**
 * Created by Venelin on 12.4.2017 г..
 */
public class GroupAttackCommand implements Command {

    private AttackGroup group;

    public GroupAttackCommand(AttackGroup group) {
        this.group = group;
    }

    @Override
    public void execute() {
        this.group.groupAttack();
    }
}
