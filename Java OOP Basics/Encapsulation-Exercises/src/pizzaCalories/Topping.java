package pizzaCalories;


public class Topping {
    private static final Double DEFAULT_TOPPING_MODIFIER = 2.0;

    private String type;
    private Double weight;

    public Topping(String type, Double weight) {
        this.setType(type);
        this.setWeight(weight);
    }

    public Double getCalories() {
        return DEFAULT_TOPPING_MODIFIER * this.getWeight() * this.getTypeModifier();
    }

    private Double getTypeModifier() {
        String type = this.getType().toLowerCase();
        switch (type) {
            case "meat":
                return 1.2;
            case "veggies":
                return 0.8;
            case "cheese":
                return 1.1;
            case "sauce":
                return 0.9;
            default:
                return null;
        }
    }

    private String getType() {
        return this.type;
    }

    private Double getWeight() {
        return this.weight;
    }

    private void setType(String type) {
        if (type == null || (!"meat".equals(type.toLowerCase()) && !"veggies".equals(type.toLowerCase())
                && !"cheese".equals(type.toLowerCase()) && !"sauce".equals(type.toLowerCase()))) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
        this.type = type;
    }

    private void setWeight(Double weight) {
        if (weight < 1 || 50 < weight) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.getType()));
        }
        this.weight = weight;
    }
}
