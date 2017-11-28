package app.models;

import app.observer.ObservableTarget;

public interface Attacker {
    void attack();
    void setTarget(ObservableTarget target);
}
