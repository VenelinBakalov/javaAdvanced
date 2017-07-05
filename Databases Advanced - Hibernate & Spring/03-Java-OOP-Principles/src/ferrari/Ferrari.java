package ferrari;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public class Ferrari implements Car{

    private static final String model = "488-Spider";

    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", Ferrari.model, this.useBrakes(), this.pushGas(), this.getDriver());
    }

    public String getDriver() {
        return driver;
    }
}
