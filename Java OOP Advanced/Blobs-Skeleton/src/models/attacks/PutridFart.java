package models.attacks;

import models.Blob;

public class PutridFart extends AbstractAttack {

    public void execute(Blob source, Blob target) {
        target.respond(source.getDamage());
    }
}
