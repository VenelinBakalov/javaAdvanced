package commandInterpreter.commands;

import annotations.Inject;
import models.BlobsRepository;
import factories.AttackFactory;
import factories.BehaviorFactory;
import interfaces.Attack;
import interfaces.Behavior;
import models.Blob;

/**
 * Created by Venelin on 8.4.2017 г..
 */
public class CreateCommand extends Command {

    @Inject private BehaviorFactory behaviorFactory;
    @Inject private AttackFactory attackFactory;
    @Inject private BlobsRepository repository;

    public CreateCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        String blobName = super.getData()[1];
        int health = Integer.parseInt(super.getData()[2]);
        int damage = Integer.parseInt(super.getData()[3]);
        String behaviorType = super.getData()[4];
        String attackType = super.getData()[5];

        try {
            Behavior behavior = this.behaviorFactory.createBehavior(behaviorType);
            Attack attack = this.attackFactory.createAttack(attackType);

            Blob blob = new Blob(blobName, health, damage, behavior, attack);
            this.repository.add(blob);

        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        this.repository.update();
    }
}
