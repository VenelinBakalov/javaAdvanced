package app;

import app.homes.Home;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class City {

    private List<Home> homes;

    public City() {
        this.homes = new ArrayList<>();
    }

    public void addHome(Home home) {
        this.homes.add(home);
    }

    public void removeHome(Home home) {
        this.homes.remove(home);
    }

    int getPopulation(){
        return this.homes.stream()
                .mapToInt(Home::getPeopleCount)
                .sum();
    }

    double getConsumption() {
        return this.homes.stream()
                .mapToDouble(Home::getConsumption)
                .sum();
    }

    void payBills() {

    }

    void receiveSalaries() {

    }

}
