package models.vehicles.nonMotor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "bikes")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Bike extends NonMotorVehicle {

    private int shiftsCount;
    private String color;

    public Bike() {
    }

    @Column(name = "shifts_count")
    public int getShiftsCount() {
        return shiftsCount;
    }

    public void setShiftsCount(int shiftsCount) {
        this.shiftsCount = shiftsCount;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
