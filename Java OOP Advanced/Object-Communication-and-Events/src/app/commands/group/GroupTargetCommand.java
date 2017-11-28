package app.commands.group;

import app.commands.Command;
import app.mediator.AttackGroup;
import app.models.Target;
import app.observer.ObservableTarget;

/**
 * Created by Venelin on 12.4.2017 г..
 */
public class GroupTargetCommand implements Command {

    private AttackGroup group;
    private ObservableTarget target;

    public GroupTargetCommand(AttackGroup group, ObservableTarget target) {
        this.group = group;
        this.target = target;
    }

    @Override
    public void execute() {
        this.group.groupTarget(target);
    }
}
