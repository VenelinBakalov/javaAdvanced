package dependencyInversionSkeleton;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public enum Operation {
    ADDITION('+'), SUBTRACTION('-'), DIVISION('/'), MULTIPLICATION('*');

    private char operationType;

    Operation(char operationType) {
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }

    public char getOperationType() {
        return operationType;
    }
}
