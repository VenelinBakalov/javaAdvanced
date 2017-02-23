package catLady;

public class Siamese extends Cat{

    private int earSize;

    public Siamese(String name, int earSize) {
        super(name, "Siamese");
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", super.getType(), super.getName(), this.earSize);
    }
}
