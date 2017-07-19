package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "occupancies")
public class Occupancy {

    private long id;
    private LocalDate dateOccupied;
    private Customer customer;
    private Room room;
    private BigDecimal rateApplied;
    private BigDecimal phoneCharge;
    private String notes;

    public Occupancy() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "date_occupied")
    public LocalDate getDateOccupied() {
        return dateOccupied;
    }

    public void setDateOccupied(LocalDate dateOccupied) {
        this.dateOccupied = dateOccupied;
    }

    @ManyToOne
    @JoinColumn(name = "account_number", referencedColumnName = "account_number")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "room_number", referencedColumnName = "room_number")
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Column(name = "rate_applied")
    public BigDecimal getRateApplied() {
        return rateApplied;
    }

    public void setRateApplied(BigDecimal rateApplied) {
        this.rateApplied = rateApplied;
    }

    @Column(name = "phone_charge")
    public BigDecimal getPhoneCharge() {
        return phoneCharge;
    }

    public void setPhoneCharge(BigDecimal phoneCharge) {
        this.phoneCharge = phoneCharge;
    }

    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
