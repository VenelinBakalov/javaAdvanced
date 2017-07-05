package ferrari;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public interface Car {

    default String useBrakes() {
        return "Brakes!";
    }

    default String pushGas() {
        return "Zadu6avam sA!";
    }
}
