package skeleton.P04_DetailPrinter;

/**
 * Created by Venelin on 4.4.2017 г..
 */
public class Worker extends Employee {

    private int id;

    public Worker(String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.id;
    }
}
