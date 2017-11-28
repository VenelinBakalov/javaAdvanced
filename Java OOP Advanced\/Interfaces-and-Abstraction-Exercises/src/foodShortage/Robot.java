package foodShortage;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Robot implements Identifiable {

    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public boolean isFake(String id) {
        return this.id.endsWith(id);
    }

    @Override
    public String getId() {
        return id;
    }
}
