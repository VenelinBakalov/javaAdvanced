package game.entities;


public class Stats {
    private static final double DAMAGE_REDUCE_RATE = 0.1;

    private Player player;

    private double health;
    private double currentHealth;

    private double mana;
    private double currentMana;

    private double armor;


    public void takeDamage(int damage) {
        this.currentHealth -= (damage - this.armor * DAMAGE_REDUCE_RATE);
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }

    public double getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(double currentMana) {
        this.currentMana = currentMana;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }
}
