package commandInterpreter.commands;

import annotations.Inject;
import models.BlobsRepository;
import models.Blob;

/**
 * Created by Venelin on 8.4.2017 г..
 */
public class AttackCommand extends Command {

    @Inject private BlobsRepository repository;

    public AttackCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        String attackerName = super.getData()[1];
        String targetName = super.getData()[2];

        Blob attacker = this.repository.find(attackerName);
        Blob target = this.repository.find(targetName);
        attacker.attack(target);

        this.repository.update();
    }
}
