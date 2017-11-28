package models.attacks;

import interfaces.Attack;
import models.Blob;

public abstract class AbstractAttack implements Attack {

    protected void targetRespond(Blob target, int damage) {
        int currentHealth = target.getHealth();
        currentHealth -= damage;
        target.setHealth(currentHealth);
    }
}
