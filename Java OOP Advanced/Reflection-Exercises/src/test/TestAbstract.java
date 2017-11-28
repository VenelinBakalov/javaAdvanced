package test;

/**
 * Created by Venelin on 30.3.2017 г..
 */
public abstract class TestAbstract {

    private String name;

    protected TestAbstract(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

