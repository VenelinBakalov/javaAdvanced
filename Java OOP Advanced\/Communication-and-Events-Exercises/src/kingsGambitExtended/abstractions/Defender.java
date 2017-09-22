package kingsGambitExtended.abstractions;

/**
 * Created by Venelin on 13.4.2017 г..
 */
public interface Defender {

    void respond();

    String getDefenderName();

    int getHp();

    void setHp(int hp);
}
