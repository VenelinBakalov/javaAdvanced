package models.attacks;

import models.Blob;

public class PutridFartAttack extends AbstractAttack {

    @Override
    public void execute(Blob source, Blob target) {
        if (source.getHealth() <= 0 || target.getHealth() <= 0) {
            return;
        }
        super.targetRespond(target, source.getDamage());
    }
}
