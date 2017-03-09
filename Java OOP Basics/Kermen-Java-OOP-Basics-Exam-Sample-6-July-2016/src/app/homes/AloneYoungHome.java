package app.homes;

import app.Room;
import app.items.Device;
import app.people.Person;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class AloneYoungHome extends Home {
    private static final int ROOMS_COUNT = 1;
    private static final int ROOMS_CONSUMPTION = 10;

    public AloneYoungHome(Person person, Device laptop) {
        this.people.add(person);
        this.devices.add(laptop);
    }


    @Override
    public void addRooms() {
        this.addRooms(ROOMS_COUNT, ROOMS_CONSUMPTION);
    }
}
