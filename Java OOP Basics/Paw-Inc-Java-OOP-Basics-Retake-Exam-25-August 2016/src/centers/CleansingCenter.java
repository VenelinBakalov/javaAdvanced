package centers;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class CleansingCenter extends Center {
    private static final String CLEANSED_STATUS = "CLEANSED";

    public CleansingCenter(String name) {
        super(name);
    }

    public void cleanse(){
        this.getStoredAnimals().forEach(a -> a.setCleansingStatus(CLEANSED_STATUS));
    }
}
