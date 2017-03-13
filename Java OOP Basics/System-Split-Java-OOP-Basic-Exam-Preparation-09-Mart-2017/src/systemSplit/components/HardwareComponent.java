package systemSplit.components;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Venelin on 9.3.2017 г..
 */
public abstract class HardwareComponent extends Component {

    private int memoryTaken;
    private int capacityTaken;
    private Map<String, SoftwareComponent> softwareComponents;

    protected HardwareComponent(String name, String type) {
        super(name, type);

        this.softwareComponents = new LinkedHashMap<>();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void registerSoftwareComponent(SoftwareComponent softwareComponent) {
        if (this.getCapacityTaken() + softwareComponent.getCapacity() <= this.getCapacity()) {
            this.softwareComponents.put(softwareComponent.getName(), softwareComponent);
            this.setCapacityTaken(this.getCapacityTaken() + softwareComponent.getCapacity());
            this.setMemoryTaken(this.getMemoryTaken() + softwareComponent.getMemory());
        }
    }

    public void releaseSoftwareComponent(String softwareComponentName) {
        SoftwareComponent component = this.softwareComponents.get(softwareComponentName);
        this.setCapacityTaken(this.getCapacityTaken() - component.getCapacity());
        this.setMemoryTaken(this.getMemoryTaken() - component.getMemory());
        this.softwareComponents.remove(softwareComponentName);
    }

    public Map<String, SoftwareComponent> getSoftwareComponents() {
        return Collections.unmodifiableMap(softwareComponents);
    }

    public int getMemoryTaken() {
        return memoryTaken;
    }

    public int getCapacityTaken() {
        return capacityTaken;
    }

    protected abstract void calculateMemory(int memory);

    protected abstract void calculateCapacity(int capacity);

    private void setMemoryTaken(int memoryTaken) {
        this.memoryTaken = memoryTaken;
    }

    private void setCapacityTaken(int capacityTaken) {
        this.capacityTaken = capacityTaken;
    }

}
