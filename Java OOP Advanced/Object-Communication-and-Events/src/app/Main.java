package app;

import app.commands.*;
import app.commands.group.GroupAttackCommand;
import app.commands.group.GroupTargetCommand;
import app.commands.individual.AttackCommand;
import app.commands.individual.TargetAndAttackCommand;
import app.logger.CombatLogger;
import app.logger.ErrorLogger;
import app.logger.EventLogger;
import app.logger.Handler;
import app.mediator.AttackGroup;
import app.mediator.Group;
import app.models.Dragon;
import app.models.Target;
import app.models.Warrior;
import app.observer.ObservableTarget;

/**
 * Created by Venelin on 12.4.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        Handler combatLogger = new CombatLogger();
        Handler errorLogger = new ErrorLogger();
        Handler eventLogger = new EventLogger();

        combatLogger.setSuccessor(eventLogger);
        errorLogger.setSuccessor(errorLogger);

        AttackGroup group = new Group();
        group.addMember(new Warrior("Gosho", 10, combatLogger));
        group.addMember(new Warrior("Stamat", 15, combatLogger));

        ObservableTarget dragon = new Dragon("Miro", 10, 100, combatLogger);

        Executor commandExecutor = new CommandExecutor();

        Command groupTargetCommand = new GroupTargetCommand(group, dragon);
        Command groupAttack = new GroupAttackCommand(group);
        commandExecutor.executeCommand(groupTargetCommand);
        commandExecutor.executeCommand(groupAttack);

    }
}
