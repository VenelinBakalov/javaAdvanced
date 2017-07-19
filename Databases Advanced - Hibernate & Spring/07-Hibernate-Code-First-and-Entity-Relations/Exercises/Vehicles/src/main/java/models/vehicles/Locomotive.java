package models.vehicles;

import models.vehicles.motor.Train;

import javax.persistence.*;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "locomotives")
public class Locomotive {

    private Long id;
    private String model;
    private int power;
    private Train train;

    public Locomotive() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "power")
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @OneToOne(mappedBy = "locomotive")
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
