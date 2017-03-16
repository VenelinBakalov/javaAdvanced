package mood3;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public abstract class Character<E, P extends Number> implements GameObject<E, P> {

    private String username;
    private E hashedPassword;
    private int level;
    protected P specialPoints;

    protected Character(String username, int level, P specialPoints) {
        this.username = username;
        this.level = level;
        this.specialPoints = specialPoints;
    }


    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public E getHashedPassword() {
        return this.hashedPassword;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public P getSpecialPoints() {
        return this.specialPoints;
    }

    @Override
    public void setHashedPassword(E hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
