package animals;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class Animal {
    private static final String DEFAULT_CLEANSING_STATUS = "UNCLEANSED";

    private String name;
    private int age;
    private String cleansingStatus;
    private String adoptionCenter;

    public Animal(String name, int age, String centerName) {
        this.setName(name);
        this.setAge(age);
        this.setCleansingStatus(DEFAULT_CLEANSING_STATUS);
        this.setAdoptionCenter(centerName);
    }

    public String getName() {
        return name;
    }

    public String getCleansingStatus() {
        return cleansingStatus;
    }

    public void setCleansingStatus(String cleansingStatus) {
        this.cleansingStatus = cleansingStatus;
    }

    public String getAdoptionCenter() {
        return adoptionCenter;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setAdoptionCenter(String adoptionCenter) {
        this.adoptionCenter = adoptionCenter;
    }
}
