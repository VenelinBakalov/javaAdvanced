package infernoInfinity;

/**
 * Created by Venelin on 24.3.2017 г..
 */
public enum WeaponType {
    AXE(5, 10, 4), SWORD(4, 6, 3), KNIFE(3, 4, 2);

    private int minDamage;
    private int maxDamage;
    private int socketsCount;

    WeaponType(int minDamage, int maxDamage, int socketsCount) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.socketsCount = socketsCount;
    }

    public int getSocketsCount() {
        return this.socketsCount;
    }
}
