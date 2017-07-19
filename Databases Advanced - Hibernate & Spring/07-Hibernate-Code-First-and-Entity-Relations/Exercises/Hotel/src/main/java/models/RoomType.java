package models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "room_types")
public class RoomType {

    private long id;
    private String roomType;
    private String notes;
    private Set<Room> rooms;

    public RoomType() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "room_type", unique = true)
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @OneToMany(mappedBy = "roomType")
    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
