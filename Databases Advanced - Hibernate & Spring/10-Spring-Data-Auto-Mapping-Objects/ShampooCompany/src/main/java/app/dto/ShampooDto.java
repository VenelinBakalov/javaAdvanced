package app.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 20.7.2017 г..
 */
public class ShampooDto implements Serializable {
    private String labelName;

    private String batchName;

    private Set<IngredientDto> ingredients;

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Set<IngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientDto> ingredients) {
        this.ingredients = ingredients;
    }


    @Override
    public String toString() {
        return "ShampooDto{" +
                "labelName='" + labelName + '\'' +
                ", batchName='" + batchName + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
