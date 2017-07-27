package app.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by User on 25.7.2017 г..
 */
public abstract class BaseIngredientDto implements Serializable {

    private String name;

    private BigDecimal price;

    public BaseIngredientDto () {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "IngredientDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
