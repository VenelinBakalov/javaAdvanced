package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by Guest Lector on 17-Jul-17.
 */
@Entity
@Table(name = "chemical_ingredient")
@PrimaryKeyJoinColumn(name = "id")
public abstract class BasicChemicatIngredient extends BasicIngredient {

    @Column(name = "chemical_formula")
    private String chemicalFormula;

    public BasicChemicatIngredient(String name, BigDecimal price, String chemicalFormula) {
        super(name, price);
        this.chemicalFormula = chemicalFormula;
    }

    public String getChemicalFormula() {
        return chemicalFormula;
    }

    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }
}
