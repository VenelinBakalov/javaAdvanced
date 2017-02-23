package catLady;

public class Cymric extends Cat{

    private double furLength;

    public Cymric(String name, double furLength) {
        super(name, "Cymric");
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", super.getType(), super.getName(), this.furLength);
    }
}
