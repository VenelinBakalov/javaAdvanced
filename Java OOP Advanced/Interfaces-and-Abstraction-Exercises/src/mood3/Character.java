package mood3;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public abstract class Character {

    private String username;
    private String hashedPassword;
    private int level;

    protected Character(String username, int level) {
        this.username = username;
        this.level = level;
    }
}
