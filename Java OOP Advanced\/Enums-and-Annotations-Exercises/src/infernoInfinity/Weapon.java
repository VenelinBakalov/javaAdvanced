package infernoInfinity;

/**
 * Created by Venelin on 24.3.2017 г..
 */

@Information(author = "Pesho", revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"})
public class Weapon implements Comparable<Weapon> {

    private String name;
    private WeaponType type;
    private GemType[] gems;

    private int minDamage;
    private int maxDamage;
    private int strength;
    private int agility;
    private int vitality;

    private double itemLevel;

    public Weapon(String name, WeaponType type) {
        this.name = name;
        this.type = type;
        this.gems = new GemType[type.getSocketsCount()];

        this.resetStats();
        this.getWeaponTypeStats();
    }

    public void addGem(int index, GemType gem) {
        if (index < 0 || index >= this.gems.length) {
            throw new IllegalArgumentException("Hakuna Matata! What a wonderful phrase!");
        }
        if (this.gems[index] != null) {
            this.removeGem(index);
        }
        this.gems[index] = gem;
        this.calculateGemStatsIncrease(gem);

    }

    public void removeGem(int index) {
        if (index < 0 || index >= this.gems.length) {
            throw new IllegalArgumentException("Hakuna Matata! Ain't no passing craaaaze!");
        }
        GemType gem = this.gems[index];
        this.gems[index] = null;
        if (gem != null) {
            this.calculateGemStatsDecrease(gem);
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality", this.name,
                this.minDamage, this.maxDamage, this.strength, this.agility, this.vitality);
    }

    @Override
    public int compareTo(Weapon weapon) {
        return Double.compare(this.getItemLevel(), weapon.getItemLevel());
    }

    public void print() {
        System.out.println(String.format("%s (Item Level: %.1f)", this.toString(), this.getItemLevel()));
    }

    private double getItemLevel() {
        return (this.minDamage + this.maxDamage) / 2.0 + this.strength + this.agility + this.vitality;
    }

    private void getWeaponTypeStats() {
        this.minDamage += this.type.getMinDamage();
        this.maxDamage += this.type.getMaxDamage();
    }

    private void calculateGemStatsIncrease(GemType gem) {
       this.increaseStrength(gem.getStrength());
        this.increaseAgility(gem.getAgility());
        this.vitality += gem.getVitality();
    }

    private void calculateGemStatsDecrease(GemType gem) {
        this.decreaseStrength(gem.getStrength());
        this.decreaseAgility(gem.getAgility());
        this.vitality -= gem.getVitality();
    }

    private void increaseStrength(int strength) {
        this.strength += strength;
        this.minDamage += strength * 2;
        this.maxDamage += strength * 3;
    }

    private void decreaseStrength(int strength) {
        this.strength -= strength;
        this.minDamage -= strength * 2;
        this.maxDamage -= strength * 3;
    }

    private void increaseAgility(int agility) {
        this.agility += agility;
        this.minDamage += agility;
        this.maxDamage += agility * 4;
    }

    private void decreaseAgility(int agility) {
        this.agility -= agility;
        this.minDamage -= agility;
        this.maxDamage -= agility * 4;
    }

    private void resetStats() {
        this.minDamage = 0;
        this.maxDamage = 0;
        this.strength = 0;
        this.agility = 0;
        this.vitality = 0;
    }
}
