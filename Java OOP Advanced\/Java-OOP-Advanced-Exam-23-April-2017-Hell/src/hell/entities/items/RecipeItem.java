package hell.entities.items;

import hell.interfaces.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public class RecipeItem extends BaseItem implements Recipe {

    private List<String> requiredItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus,
                      String... requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.setRequiredItems(requiredItems);
    }

    @Override
    public List<String> getRequiredItems() {
        return new ArrayList<>(this.requiredItems);
    }

    private void setRequiredItems(String... requiredItems) {
        if (requiredItems.length == 0) {
            throw new IllegalArgumentException();
        }
        this.requiredItems = Arrays.asList(requiredItems);
    }
}
