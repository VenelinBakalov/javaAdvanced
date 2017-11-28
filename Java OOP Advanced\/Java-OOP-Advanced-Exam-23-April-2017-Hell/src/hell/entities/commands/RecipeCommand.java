package hell.entities.commands;

import hell.entities.Repositories.Repository;
import hell.entities.annotations.Inject;
import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public class RecipeCommand implements Executable {


    public static final String ADDED_RECIPE_TO_HERO_MESSAGE = "Added recipe - %s to Hero - %s";
    @Inject private String[] data;
    @Inject private Repository<Hero> heroRepository;

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String itemName = this.data[0];
        String heroName = this.data[1];
        int strengthBonus = Integer.parseInt(this.data[2]);
        int agilityBonus = Integer.parseInt(this.data[3]);
        int intelligenceBonus = Integer.parseInt(this.data[4]);
        int hitPointsBonus = Integer.parseInt(this.data[5]);
        int damageBonus = Integer.parseInt(this.data[6]);

        List<String> requiredItems = new ArrayList<>();

        for (int i = 7; i < this.data.length; i++) {
            requiredItems.add(this.data[i]);
        }

        Recipe recipe = new RecipeItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus,
                requiredItems.toArray(new String[requiredItems.size()]));

        this.heroRepository.get(heroName).addRecipe(recipe);


        return String.format(ADDED_RECIPE_TO_HERO_MESSAGE, recipe.getName(), heroName);
    }
}
