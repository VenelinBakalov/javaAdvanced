package models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "rooms")
public class Room {

    private int roomNumber;
    private RoomType roomType;
    private BedType bedType;
    private int rate;
    private RoomStatus roomStatus;
    private String notes;

    private Set<Occupancy> occupancies;

    public Room() {
    }

    @Id
    @Column(name = "room_number")
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @ManyToOne
    @JoinColumn(name = "room_type", referencedColumnName = "id")
    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @ManyToOne
    @JoinColumn(name = "bed_type", referencedColumnName = "id")
    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    @Column(name = "rate")
    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @ManyToOne
    @JoinColumn(name = "room_status", referencedColumnName = "id")
    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @OneToMany(mappedBy = "room")
    public Set<Occupancy> getOccupancies() {
        return occupancies;
    }

    public void setOccupancies(Set<Occupancy> occupancies) {
        this.occupancies = occupancies;
    }
}
