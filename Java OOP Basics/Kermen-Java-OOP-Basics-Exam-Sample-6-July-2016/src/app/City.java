package app;

import app.homes.Home;

import java.util.ArrayList;
import java.util.Iterator;
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

    public int getPopulation(){
        return this.homes.stream()
                .mapToInt(Home::getPeopleCount)
                .sum();
    }

    public double getConsumption() {
        return this.homes.stream()
                .mapToDouble(Home::getConsumption)
                .sum();
    }

    public void payBills() {

        // while(iterator.hasNext())
        // or
        // oburnat for cikul

        for (Iterator<Home> iterator = this.homes.iterator(); iterator.hasNext();) {
            Home currentHome = iterator.next();
            if (!currentHome.payBills()) {
                iterator.remove();
            }
        }
    }

    public void receiveSalaries() {
        homes.forEach(Home::receiveSalary);
    }

}
