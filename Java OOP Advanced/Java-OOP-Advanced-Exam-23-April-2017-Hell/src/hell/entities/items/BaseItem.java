package hell.entities.items;

import hell.interfaces.Item;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public abstract class BaseItem implements Item {

    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int hitPointsBonus;
    private int damageBonus;

    protected BaseItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.hitPointsBonus = hitPointsBonus;
        this.damageBonus = damageBonus;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrengthBonus() {
        return this.strengthBonus;
    }

    @Override
    public int getAgilityBonus() {
        return this.agilityBonus;
    }

    @Override
    public int getIntelligenceBonus() {
        return this.intelligenceBonus;
    }

    @Override
    public int getHitPointsBonus() {
        return this.hitPointsBonus;
    }

    @Override
    public int getDamageBonus() {
        return this.damageBonus;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("###Item: %s", this.getName())).append(System.lineSeparator());
        sb.append(String.format("###+%d Strength", this.getStrengthBonus())).append(System.lineSeparator());
        sb.append(String.format("###+%d Agility", this.getAgilityBonus())).append(System.lineSeparator());
        sb.append(String.format("###+%d Intelligence", this.getIntelligenceBonus())).append(System.lineSeparator());
        sb.append(String.format("###+%d HitPoints", this.getHitPointsBonus())).append(System.lineSeparator());
        sb.append(String.format("###+%d Damage", this.getDamageBonus())).append(System.lineSeparator());

        return sb.toString();
    }
}
