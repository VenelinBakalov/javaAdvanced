package models.attacks;

import interfaces.Attack;
import models.Blob;

public abstract class AbstractAttack implements Attack {
    public abstract void execute(Blob attacker, Blob target);
}
