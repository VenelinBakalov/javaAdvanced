package models.vehicles.nonMotor;

import models.vehicles.motor.Vehicle;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "non_motor_vehicles")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public abstract class NonMotorVehicle extends Vehicle {

    public NonMotorVehicle() {
    }
}
