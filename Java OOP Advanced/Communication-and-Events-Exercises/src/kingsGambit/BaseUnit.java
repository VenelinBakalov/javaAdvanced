package kingsGambit;

/**
 * Created by Venelin on 13.4.2017 г..
 */
public abstract class BaseUnit {

    private String name;

    protected BaseUnit(String name) {
        this.name = name;
    }

    protected String getName() {
        return this.name;
    }
}
