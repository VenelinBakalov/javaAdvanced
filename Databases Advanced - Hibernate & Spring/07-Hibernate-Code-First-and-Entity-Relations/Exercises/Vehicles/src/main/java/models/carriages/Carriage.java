package models.carriages;

import models.vehicles.motor.Train;

import javax.persistence.*;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "carriages")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Carriage {

    private Long id;
    private int seatsCapacity;
    private Train train;

    public Carriage() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "seats_capacity")
    public int getSeatsCapacity() {
        return seatsCapacity;
    }

    public void setSeatsCapacity(int seatsCapacity) {
        this.seatsCapacity = seatsCapacity;
    }

    @ManyToOne
    @JoinColumn(name = "train_id", referencedColumnName = "vehicle_id")
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
