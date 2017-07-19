package models.vehicles.motor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "cargo_ships")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class CargoShip extends Ship {

    private double maxLoadKilograms;

    public CargoShip() {
    }

    @Column(name = "max_load_kilograms")
    public double getMaxLoadKilograms() {
        return maxLoadKilograms;
    }

    public void setMaxLoadKilograms(double maxLoadKilograms) {
        this.maxLoadKilograms = maxLoadKilograms;
    }
}
