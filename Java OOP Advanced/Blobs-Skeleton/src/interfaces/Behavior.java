package interfaces;

import models.Blob;

public interface Behavior {

    void trigger(Blob source);

    boolean isTriggered();

    void applyRecurrentEffect(Blob source);

}
