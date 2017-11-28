package ferrari;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Ferrari implements Car {

    private static final String MODEL = "488-Spider";

    private String driverName;

    public Ferrari(String name) {
        this.driverName = name;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGash() {
        return "Zadu6avam sA!";
    }

    public static String getModel() {
        return MODEL;
    }

    public String getDriverName() {
        return this.driverName;
    }
}
