package borderControl;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public class Robot extends Identifiable{

    private String model;

    public Robot(String model, String id) {
        super(id);
        this.model = model;
    }
}
