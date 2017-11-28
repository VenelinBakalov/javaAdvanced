package skeleton.P04_DetailPrinter;

import java.util.Arrays;

public class Manager extends Employee {

    private String[] documents;

    public Manager(String name, String... documents) {
        super(name);
        this.documents = documents;
    }

    @Override
    public String toString() {
        return super.toString() + Arrays.toString(this.documents);
    }
}
