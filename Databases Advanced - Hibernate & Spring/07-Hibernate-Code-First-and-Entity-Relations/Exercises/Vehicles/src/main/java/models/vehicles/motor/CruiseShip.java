package models.vehicles.motor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "cruise_ships")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class CruiseShip extends Ship {

    private int passengersCapacity;

    public CruiseShip() {
    }

    @Column(name = "passengers_capacity")
    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    public void setPassengersCapacity(int passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }
}
