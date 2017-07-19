package models.vehicles.motor;

import models.carriages.Carriage;
import models.vehicles.Locomotive;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "trains")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Train extends MotorVehicle {

    private Locomotive locomotive;
    private int numberOfCarriages;
    private List<Carriage> carriages;

    public Train() {
    }

    @OneToOne
    @JoinColumn(name = "locomotive_id", referencedColumnName = "id")
    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    @Column(name = "number_of_carriages")
    public int getNumberOfCarriages() {
        return numberOfCarriages;
    }

    public void setNumberOfCarriages(int numberOfCarriages) {
        this.numberOfCarriages = numberOfCarriages;
    }

    @OneToMany(mappedBy = "train")
    public List<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }
}
