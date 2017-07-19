package models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Venelin on 18.7.2017 г..
 */
@Entity
@Table(name = "store_locations")
public class StoreLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "location_name")
    private String locationName;

    @OneToMany(mappedBy = "storeLocation", targetEntity = Sale.class,
    fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Sale> salesInStore;

    public StoreLocation() {
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Set<Sale> getSalesInStore() {
        return salesInStore;
    }

    public void setSalesInStore(Set<Sale> salesInStore) {
        this.salesInStore = salesInStore;
    }
}
