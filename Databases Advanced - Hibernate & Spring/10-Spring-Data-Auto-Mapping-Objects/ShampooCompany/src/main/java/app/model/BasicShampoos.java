package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Guest Lector on 17-Jul-17.
 */
@Entity
@Table(name = "shampoos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class BasicShampoos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "label_id")
    private ClassicLabel label;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_id")
    private ProductionBatch batch;

    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "shampoos_ingredients",
            joinColumns = @JoinColumn(name = "shampoo_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"),
            foreignKey = @ForeignKey(name="fk_shampoos_ingredients_shampos" ),
            inverseForeignKey = @ForeignKey(name="fk_shampoos_ingredients_ingredients"))
    private Set<BasicIngredient> ingredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductionBatch getBatch() {
        return batch;
    }

    public void setBatch(ProductionBatch batch) {
        this.batch = batch;
    }

    public ClassicLabel getLabel() {
        return label;
    }

    public void setLabel(ClassicLabel label) {
        this.label = label;
    }

    public Set<BasicIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<BasicIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "BasicShampoos{" +
                "id=" + id +
                ", label=" + label +
                ", ingredients=" + ingredients +
                ", productionBatch=" + batch +
                '}';
    }
}
