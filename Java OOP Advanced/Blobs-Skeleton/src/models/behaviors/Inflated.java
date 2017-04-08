package models.behaviors;

import models.Blob;

/**
 * Created by Venelin on 7.4.2017 г..
 */
public class Inflated extends AbstractBehavior {

    private static final int INFLATED_HEALTH_GAIN = 50;
    private static final int INFLATED_HEALTH_DECREMENT = 10;

    public Inflated() {
    }

    @Override
    public void trigger(Blob source) {
        if (!super.isTriggered()) {
            super.setIsTriggered(true);
            this.applyTriggerEffect(source);
        }
    }

    @Override
    public void applyRecurrentEffect(Blob source) {
        if (super.toDelayRecurrentEffect()) {
            super.setToDelayRecurrentEffect(false);
        } else {
            source.setHealth(source.getHealth() - INFLATED_HEALTH_DECREMENT);
        }
    }

    private void applyTriggerEffect(Blob source) {
        source.setHealth(source.getHealth() + INFLATED_HEALTH_GAIN);
    }
}
