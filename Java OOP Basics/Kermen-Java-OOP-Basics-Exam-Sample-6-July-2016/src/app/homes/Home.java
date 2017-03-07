package app.homes;

import app.people.Child;
import app.items.Device;
import app.people.Person;
import app.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public abstract class Home {

    private List<Room> rooms;
    private List<Device> devices;
    private List<Person> people;
    private List<Child> children;
    double budget;
    double bills;

    public Home(Room room) {
        this.room = room;
        this.devices = new ArrayList<>();
        this.people = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    void payBills() {

    }

    void receiveSalary() {

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
