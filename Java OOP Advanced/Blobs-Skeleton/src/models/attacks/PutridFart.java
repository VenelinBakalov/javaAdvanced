package models.attacks;

import models.Blob;

public class PutridFart extends AbstractAttack {

    @Override
    public void execute(Blob source, Blob target) {
        super.targetRespond(target, source.getDamage());
    }
}
