package enums;

public enum EmergencyLevel {
    MINOR,
    MAJOR,
    DISASTER;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
