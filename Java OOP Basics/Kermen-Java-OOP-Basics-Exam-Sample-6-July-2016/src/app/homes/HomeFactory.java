package app.homes;

import app.items.Device;
import app.people.Child;
import app.people.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 8.3.2017 г..
 */
public class HomeFactory {

    public Home createHome(List<String> homeArgs, List<Child> children) {
        String homeType = homeArgs.get(0);
        Double[] arguments = homeArgs.stream().skip(1).map(Double::parseDouble).toArray(Double[]::new);
        Home home = null;
        switch (homeType) {
            case "YoungCouple":
                home = new YoungCoupleHome(
                        new Person(arguments[0]),
                        new Person(arguments[1]),
                        new Device(arguments[2]),
                        new Device(arguments[3]),
                        new Device(arguments[4]));
                break;
            case "YoungCoupleWithChildren":
                home = new YoungCoupleWithChildrenHome(
                        new Person(arguments[0]),
                        new Person(arguments[1]),
                        new Device(arguments[2]),
                        new Device(arguments[3]),
                        new Device(arguments[4]),
                        children);
                break;
            case "AloneYoung":
                home = new AloneYoungHome(
                        new Person(arguments[0]),
                        new Device(arguments[1]));
                break;
            case "OldCouple":
                home = new OldCoupleHome(
                        new Person(arguments[0]),
                        new Person(arguments[1]),
                        new Device(arguments[2]),
                        new Device(arguments[3]),
                        new Device(arguments[4]));
                break;
            case "AloneOld":
                home = new AloneOldHome(
                        new Person(arguments[0]));
                break;
            default:
                break;
        }

        home.addRooms();
        home.calculateSalaries();
        home.calculateBills();

        return home;
    }
}
