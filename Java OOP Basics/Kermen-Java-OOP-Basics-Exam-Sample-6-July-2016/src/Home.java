import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class Home {

    private Room room;
    private List<Device> devices;
    private List<Person> people;
    private List<Child> children;

    public Home(Room room) {
        this.room = room;
        this.devices = new ArrayList<>();
        this.people = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    protected void addDevice(Device device) {
        this.devices.add(device);
    }

    protected void addPerson(Person person) {
        this.people.add(person);
    }

    protected void addChild(Child child) {
        this.children.add(child);
    }
}
