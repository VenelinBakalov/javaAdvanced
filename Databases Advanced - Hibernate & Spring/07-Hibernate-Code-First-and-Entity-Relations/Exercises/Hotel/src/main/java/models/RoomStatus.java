package models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "room_status")
public class RoomStatus {

    private long id;
    private String roomStatus;
    private String notes;
    private Set<Room> rooms;

    public RoomStatus() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "room_status", unique = true)
    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @OneToMany(mappedBy = "roomStatus")
    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
