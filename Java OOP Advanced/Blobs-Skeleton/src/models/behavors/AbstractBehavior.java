package models.behavors;

import interfaces.Behavior;
import models.Blob;

public abstract class AbstractBehavior implements Behavior {

    protected boolean isTriggered;
    protected boolean toDelayRecurrentEffect;

    public AbstractBehavior() {
        this.toDelayRecurrentEffect = true;
    }

    public boolean isTriggered() {
        return this.isTriggered;
    }

    public void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }

    public boolean toDelayRecurrentEffect() {
        return this.toDelayRecurrentEffect;
    }

    public void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect){
        this.toDelayRecurrentEffect = toDelayRecurrentEffect;
    }

    public abstract void trigger(Blob source);

    public abstract void applyRecurrentEffect(Blob source);
}
