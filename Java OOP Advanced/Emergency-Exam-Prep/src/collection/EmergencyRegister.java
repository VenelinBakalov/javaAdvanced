package collection;

import models.emergencies.BaseEmergency;

public class EmergencyRegister {

    private static final Integer INITIAL_SIZE = 16;

    private BaseEmergency[] emergencyQueue;

    private Integer currentSize;

    private Integer nextIndex;

    public EmergencyRegister() {
        this.emergencyQueue = new BaseEmergency[INITIAL_SIZE];
        this.currentSize = 0;
        this.nextIndex = 0;
    }

    private void incrementNextIndex() {
        this.nextIndex++;
    }

    private void decrementNextIndex() {
        this.nextIndex--;
    }

    private void incrementCurrentSize() {
        this.currentSize++;
    }

    private void decrementCurrentSize() {
        this.currentSize--;
    }

    private void checkIfResizeNeeded() {
        if(this.currentSize == this.emergencyQueue.length) {
            this.resize();
        }
    }

    private void resize() {
        BaseEmergency[] newArray = new BaseEmergency[2 * this.currentSize];

        for (int i = 0; i < this.currentSize; i++) {
            newArray[i] = this.emergencyQueue[i];
        }

        this.emergencyQueue = newArray;
    }

    public void enqueueEmergency(BaseEmergency emergency) {
        this.checkIfResizeNeeded();

        this.emergencyQueue[this.nextIndex] = emergency;
        this.incrementNextIndex();

        this.incrementCurrentSize();
    }

    public BaseEmergency dequeueEmergency() {
        BaseEmergency removedElement = this.emergencyQueue[0];

        for (int i = 0; i < this.currentSize - 1; i++) {
            this.emergencyQueue[i] = this.emergencyQueue[i + 1];
        }

        this.decrementNextIndex();
        this.decrementCurrentSize();

        return removedElement;
    }

    public BaseEmergency peekEmergency() {
        BaseEmergency peekedElement = this.emergencyQueue[0];
        return peekedElement;
    }

    public Boolean isEmpty() {
        return this.currentSize == 0;
    }
}
