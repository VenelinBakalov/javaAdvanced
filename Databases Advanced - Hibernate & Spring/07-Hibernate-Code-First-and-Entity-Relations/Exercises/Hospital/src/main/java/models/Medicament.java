package models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "medicaments")
public class Medicament {

    private long id;
    private String name;
    private Set<Patient> patients;

    public Medicament() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name = "medicaments_patients",
    joinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"))
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
