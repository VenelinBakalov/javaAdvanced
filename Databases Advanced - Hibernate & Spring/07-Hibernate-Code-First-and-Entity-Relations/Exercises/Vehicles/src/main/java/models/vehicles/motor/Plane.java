package models.vehicles.motor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "planes")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Plane extends MotorVehicle {

    private String airlineOwner;
    private String color;
    private int passengersCapacity;

    public Plane() {
    }

    @Column(name = "airline_owner")
    public String getAirlineOwner() {
        return airlineOwner;
    }

    public void setAirlineOwner(String airlineOwner) {
        this.airlineOwner = airlineOwner;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "passengers_capacity")
    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    public void setPassengersCapacity(int passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }
}
