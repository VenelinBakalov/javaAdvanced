package app.mediator;

import app.models.Attacker;
import app.observer.ObservableTarget;

/**
 * Created by Venelin on 12.4.2017 г..
 */
public interface AttackGroup {

    void addMember(Attacker attacker);

    void groupTarget(ObservableTarget target);

    void groupAttack();
}
