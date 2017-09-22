package kingsGambit;

/**
 * Created by Venelin on 13.4.2017 г..
 */
public interface Attackable {
    
    void addDefender(Defender defender);
    
    void killDefender(String defender);
    
    void respondToAttack();
}
