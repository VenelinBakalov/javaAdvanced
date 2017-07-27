package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Guest Lector on 17-Jul-17.
 */
@Entity
@Table(name = "indredients" )
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class BasicIngredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String name;
    @Basic
    private BigDecimal price;

    @ManyToMany(mappedBy = "ingredients")
    private Set<BasicShampoos> shampoos;

    public BasicIngredient() {
    }

    public BasicIngredient(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<BasicShampoos> getShampoos() {
        return shampoos;
    }

    public void setShampoos(Set<BasicShampoos> shampoos) {
        this.shampoos = shampoos;
    }

    @Override
    public String toString() {
        return "BasicIngredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicIngredient that = (BasicIngredient) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? super.hashCode() : id.hashCode();
    }
}
