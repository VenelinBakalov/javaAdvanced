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
    protected List<Device> devices;
    protected List<Person> people;
    protected List<Child> children;
    private double budget;
    private double bills;
    private double salaries;

    protected Home() {
        this.rooms = new ArrayList<>();
        this.devices = new ArrayList<>();
        this.people = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public int getPeopleCount() {
        return this.people.size();
    }

    public double getConsumption() {
        return this.bills;
    }

    public abstract void addRooms();

    protected void calculateSalaries() {
        this.salaries = this.people.stream()
                .mapToDouble(Person::getIncome)
                .sum();
    }

    public boolean payBills() {
        if (this.budget >= this.bills) {
            this.budget -= this.bills;
            return true;
        }

        return false;
    }

    public void receiveSalary() {
        this.budget += this.salaries;
    }

    protected void calculateBills() {
        this.bills = this.rooms.stream()
                        .mapToDouble(Room::getConsumption)
                        .sum()
                +
                this.devices.stream()
                        .mapToDouble(Device::getConsumption)
                        .sum()
                +
                this.children.stream()
                        .mapToDouble(Child::getCost)
                        .sum();
    }

    protected void addRooms(int roomCount, double roomConsumption) {
        for (int i = 0; i < roomCount; i++) {
            this.rooms.add(new Room(roomConsumption));
        }
    }

}
