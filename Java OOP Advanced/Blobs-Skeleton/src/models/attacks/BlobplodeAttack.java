package models.attacks;

import models.Blob;

/**
 * Created by Venelin on 7.4.2017 г..
 */
public class BlobplodeAttack extends AbstractAttack {

    private static final int BLOBPLODE_ATTACK_DAMAGE_MULTIPLIER = 2;
    private static final int BLOBPLODE_ATTACK_HEALTH_REDUCE_RATE = 2;
    private static final int ATTACKER_MINIMUM_HEALTH_BORDER = 1;

    @Override
    public void execute(Blob attacker, Blob target) {
        if (attacker.getHealth() <= 0 || target.getHealth() <= 0) {
            return;
        }
        this.attackAffectSource(attacker);
        this.attackAffectTarget(attacker, target);
    }

    private void attackAffectSource(Blob source) {
        source.setHealth(source.getHealth() - source.getHealth() / BLOBPLODE_ATTACK_HEALTH_REDUCE_RATE);
        if (source.getHealth() <= 0) {
            source.setHealth(ATTACKER_MINIMUM_HEALTH_BORDER);
        }
    }

    private void attackAffectTarget(Blob source, Blob target) {
        int attackDamage = source.getDamage() * BLOBPLODE_ATTACK_DAMAGE_MULTIPLIER;
        super.targetRespond(target, attackDamage);
    }

}
