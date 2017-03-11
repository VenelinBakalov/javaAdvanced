package app.homes;

import app.items.Device;
import app.people.Child;
import app.people.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class YoungCoupleWithChildrenHome extends YoungCoupleHome {
    private static final int ROOMS_COUNT = 2;
    private static final int ROOMS_CONSUMPTION = 30;

    public YoungCoupleWithChildrenHome(Person male, Person female, Device tv, Device fridge, Device laptop, List<Child> children) {
        super(male, female, tv, fridge, laptop);

        this.children.addAll(children);
    }

    @Override
    public void addRooms() {
        this.addRooms(ROOMS_COUNT, ROOMS_CONSUMPTION);
    }


}
