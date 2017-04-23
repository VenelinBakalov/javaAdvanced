package hell.interfaces;

/**
 *  This is the interface for the Item entity
 *  @method String getName() - a getter for the name property of the Item
 *  @method long getStrengthBonus() - a getter for the strengthBonus property of the Item
 *  @method long getAgilityBonus() - a getter for the agilityBonus property of the Item
 *  @method long getIntelligenceBonus() - a getter for the intelligenceBonus property of the Item
 *  @method long getHitPointsBonus() - a getter for the hitPointsBonus property of the Item
 *  @method long getDamageBonus() - a getter for the damageBonus property of the Item
 */
public interface Item {
    String getName();

    int getStrengthBonus();

    int getAgilityBonus();

    int getIntelligenceBonus();

    int getHitPointsBonus();

    int getDamageBonus();
}