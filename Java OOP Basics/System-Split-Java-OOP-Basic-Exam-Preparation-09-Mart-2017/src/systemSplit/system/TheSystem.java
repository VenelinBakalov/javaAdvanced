package systemSplit.system;

import systemSplit.components.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 9.3.2017 г..
 */
public class TheSystem {

    Map<String, HardwareComponent> hardwareComponents;
    Map<String, HardwareComponent> dump;

    public TheSystem() {
        this.hardwareComponents = new LinkedHashMap<>();
        this.dump = new LinkedHashMap<>();
    }

    public void registerPowerHardware(String name, int capacity, int memory) {
        PowerHardwareComponent powerHardwareComponent = new PowerHardwareComponent(name, capacity, memory);
        this.hardwareComponents.put(name, powerHardwareComponent);
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        HeavyHardwareComponent heavyHardwareComponent = new HeavyHardwareComponent(name, capacity, memory);
        this.hardwareComponents.put(name, heavyHardwareComponent);
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            HardwareComponent hardwareComponent = this.hardwareComponents.get(hardwareComponentName);
            ExpressSoftwareComponent expressSoftwareComponent = new ExpressSoftwareComponent(name, capacity, memory);
            hardwareComponent.registerSoftwareComponent(expressSoftwareComponent);
        }
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            HardwareComponent hardwareComponent = this.hardwareComponents.get(hardwareComponentName);
            LightSoftwareComponent lightSoftwareComponent = new LightSoftwareComponent(name, capacity, memory);
            hardwareComponent.registerSoftwareComponent(lightSoftwareComponent);
        }
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            this.hardwareComponents.get(hardwareComponentName).releaseSoftwareComponent(softwareComponentName);
        }
    }

    public void dump(String hardwareComponentName) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            HardwareComponent component = this.hardwareComponents.get(hardwareComponentName);
            dump.put(hardwareComponentName, component);
            hardwareComponents.remove(hardwareComponentName);
        }
    }

    public void restore(String hardwareComponentName) {
        if (this.dump.containsKey(hardwareComponentName)) {
            HardwareComponent component = dump.get(hardwareComponentName);
            this.hardwareComponents.put(hardwareComponentName, component);
            dump.remove(component);
        }
    }

    public void dumpAnalyze() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dump Analysis\n");
        sb.append(String.format("Power Hardware Components: %d\n", getDumpHardwareComponentsCount("Power")));
        sb.append(String.format("Heavy Hardware Components: %d\n", getDumpHardwareComponentsCount("Heavy")));
        sb.append(String.format("Express Software Components: %d\n", getDumpSoftwareComponentsCount("Express")));
        sb.append(String.format("Light Software Components: %d\n", getDumpSoftwareComponentsCount("Light")));
        sb.append(String.format("Total Dumped Memory: %d\n", getTotalDumpedMemory()));
        sb.append(String.format("Total Dumped Capacity: %d", getTotalDumpedCapacity()));

        System.out.println(sb.toString());
    }

    private long getDumpSoftwareComponentsCount(String type) {
        return this.dump.values().stream()
                .flatMap(h -> h.getSoftwareComponents().values().stream().filter(s -> s.getType().equals(type)))
                .count();
    }

    private long getDumpHardwareComponentsCount(String type) {
        return this.dump.values().stream().filter(c -> c.getType().equals(type)).count();
    }

    public void destroy(String hardwareComponentName) {
        this.dump.remove(hardwareComponentName);
    }

    public String analyze() {
        StringBuilder sb = new StringBuilder();
        sb.append("System Analysis\n");
        sb.append(String.format("Hardware Components: %d\n", this.hardwareComponents.size()));
        sb.append(String.format("Software Components: %d\n", getTotalSoftwareComponentsCount()));
        sb.append(String.format("Total Operational Memory: %d / %d\n", getMemoryUsed() ,getTotalMemory()));
        sb.append(String.format("Total Capacity Taken: %d / %d", getCapacityUsed() ,getTotalCapacity()));

        return sb.toString();
    }

    public String split() {
        StringBuilder sb = new StringBuilder();

        hardwareComponents.values().stream().sorted((c1, c2) -> {
            if (c1.getType().equals("Power")) {
                return -1;
            }
            return 1;
        }).forEach(c -> {
            sb.append(String.format("Hardware Component - %s\n", c.getName()));
            sb.append(String.format("Express Software Components - %d\n", getSoftwareComponentsCount(c, "Express")));
            sb.append(String.format("Light Software Components - %d\n", getSoftwareComponentsCount(c, "Light")));
            sb.append(String.format("Memory Usage: %d / %d\n", c.getMemoryTaken(), c.getMemory()));
            sb.append(String.format("Capacity Usage: %d / %d\n", c.getCapacityTaken(), c.getCapacity()));
            sb.append(String.format("Type: %s\n", c.getType()));
            sb.append(String.format("Software Components: %s", getSoftwareComponents(c)));

        });
        return sb.toString();
    }

    private String getSoftwareComponents(HardwareComponent component) {
        if (component.getSoftwareComponents().size() == 0) {
            return "None";
        }
        List<String> componentsNames = component.getSoftwareComponents().values().stream()
                .map(Component::getName)
                .collect(Collectors.toList());

        return String.join(", ", componentsNames);
    }

    private int getSoftwareComponentsCount(HardwareComponent component, String componentType) {
        List<SoftwareComponent> components = component.getSoftwareComponents().values().stream()
                .filter(s -> s.getType().equals(componentType))
                .collect(Collectors.toList());

        return components.size();
    }

    public int getTotalSoftwareComponentsCount() {
        return this.hardwareComponents.values().stream().mapToInt(h -> h.getSoftwareComponents().size()).sum();
    }

    public int getTotalMemory() {
        return this.hardwareComponents.values().stream().mapToInt(HardwareComponent::getMemory).sum();
    }

    public int getTotalCapacity() {
        return this.hardwareComponents.values().stream().mapToInt(HardwareComponent::getCapacity).sum();
    }

    public int getMemoryUsed() {
        return this.hardwareComponents.values().stream().mapToInt(HardwareComponent::getMemoryTaken).sum();
    }

    public int getCapacityUsed() {
        return this.hardwareComponents.values().stream().mapToInt(HardwareComponent::getCapacityTaken).sum();
    }

    public int getTotalDumpedMemory() {
        return this.dump.values().stream().mapToInt(HardwareComponent::getMemoryTaken).sum();
    }

    public int getTotalDumpedCapacity() {
        return this.dump.values().stream().mapToInt(HardwareComponent::getCapacityTaken).sum();
    }
}
