package mood3;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public interface GameObject<E, P> {

    String getUsername();
    E getHashedPassword();
    int getLevel();
    P getSpecialPoints();
    void setHashedPassword(E element);
    void hashPassword();

}
