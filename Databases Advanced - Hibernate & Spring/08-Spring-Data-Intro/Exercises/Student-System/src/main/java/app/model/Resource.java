package app.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Venelin on 21.7.2017 г..
 */
@Entity
@Table(name = "resources")
public class Resource {

    private Long id;
    private String name;
    private ResourceType typeOfResource;
    private String URL;

    private Course course;
    private Set<License> licenses;

    public Resource() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type_of_resource", nullable = false)
    public ResourceType getTypeOfResource() {
        return typeOfResource;
    }

    public void setTypeOfResource(ResourceType typeOfResource) {
        this.typeOfResource = typeOfResource;
    }

    @Column(name = "url", nullable = false)
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return this.getName() + ", Type: " + this.getTypeOfResource() + ", URL: " + this.getURL();
    }

    @OneToMany(mappedBy = "resource")
    public Set<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(Set<License> licenses) {
        this.licenses = licenses;
    }
}
