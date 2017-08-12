package app.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@Entity
@Table(name = "lens")
public class Lens {

    private Long id;
    private String make;
    private Integer focalLength;
    private BigDecimal aperture;
    private String compatibleWith;
    private Photographer owner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "focal_length")
    public Integer getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(Integer focalLength) {
        this.focalLength = focalLength;
    }

    @Basic
    public BigDecimal getAperture() {
        return aperture;
    }

    public void setAperture(BigDecimal aperture) {
        this.aperture = aperture;
    }

    @Column(name = "compatible_with")
    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    public Photographer getOwner() {
        return owner;
    }

    public void setOwner(Photographer owner) {
        this.owner = owner;
    }
}
