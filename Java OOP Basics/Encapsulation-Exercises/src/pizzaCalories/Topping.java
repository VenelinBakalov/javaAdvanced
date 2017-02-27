package pizzaCalories;


public class Topping {
    private static final Double DEFAULT_TOPPING_MODIFIER = 2.0;

    private String type;
    private Double weight;

    public Double getCalories() {
        return this.DEFAULT_TOPPING_MODIFIER * this.getWeight() * this.getTypeModifier();
    }

    private Double getTypeModifier() {
        String type = this.getType();
        switch (type) {
            case "Meat":
                return 1.2;
            case "Veggies":
                return 0.8;
            case "Cheese":
                return 1.1;
            case "Sauce":
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
        if (type == null || !"Meat".equals(type) || !"Veggies".equals(type) || !"Cheese".equals(type) || !"Sauce".equals(type)) {
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
