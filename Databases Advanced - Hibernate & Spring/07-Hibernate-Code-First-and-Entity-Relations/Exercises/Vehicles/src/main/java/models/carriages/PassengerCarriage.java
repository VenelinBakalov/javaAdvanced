package models.carriages;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "passenger_carriages")
@PrimaryKeyJoinColumn(name = "carriage_id")
public class PassengerCarriage extends Carriage {

    private int standingPassengersCapacity;

    public PassengerCarriage() {
    }

    @Column(name = "standing_passengers_capacity")
    public int getStandingPassengersCapacity() {
        return standingPassengersCapacity;
    }

    public void setStandingPassengersCapacity(int standingPassengersCapacity) {
        this.standingPassengersCapacity = standingPassengersCapacity;
    }
}
