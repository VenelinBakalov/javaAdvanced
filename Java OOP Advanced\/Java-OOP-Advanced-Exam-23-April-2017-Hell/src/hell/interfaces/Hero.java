package hell.interfaces;

import java.util.Collection;

/**
 *  This is the interface for the Hero entity
 *  @method String getName() - a getter for the name property of the Hero
 *  @method long getStrength() - a getter for the strength property of the Hero
 *  @method long getAgility() - a getter for the agility property of the Hero
 *  @method long getIntelligence() - a getter for the intelligence property of the Hero
 *  @method long getHitPoints() - a getter for the hitPoints property of the Hero
 *  @method long getDamage() - a getter for the damage property of the Hero
 *  @method Collection<Item> getItems() - a getter which extracts the items from the Inventory of the Hero
 *  @method void addItem(Item item) - a method which adds an CommonItem to the Inventory of the Hero
 *  @method void addRecipe(Recipe item) - a method which adds an RecipeItem to the Inventory of the Hero
 */
public interface Hero {
    String getName();

    long getStrength();

    long getAgility();

    long getIntelligence();

    long getHitPoints();

    long getDamage();

    Collection<Item> getItems();

    void addItem(Item item);

    void addRecipe(Recipe recipe);
}