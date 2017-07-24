package app.model;

import javax.persistence.*;

/**
 * Created by Venelin on 24.7.2017 г..
 */
@Entity
@Table(name = "licences")
public class License {

    private Long id;
    private String name;

    private Resource resource;

    public License() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "resource_id", referencedColumnName = "id")
    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
