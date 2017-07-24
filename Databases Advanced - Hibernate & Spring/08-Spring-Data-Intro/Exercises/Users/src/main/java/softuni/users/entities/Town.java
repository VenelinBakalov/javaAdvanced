package softuni.users.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Venelin on 24.7.2017 г..
 */
@Entity
@Table(name = "towns")
public class Town {

    private Long id;
    private String name;
    private String country;

    private Set<User> usersBornIn;
    private Set<User> usersLivingIn;

    public Town() {
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

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "bornTown")
    public Set<User> getUsersBornIn() {
        return usersBornIn;
    }

    public void setUsersBornIn(Set<User> users) {
        this.usersBornIn = users;
    }

    @OneToMany(mappedBy = "currentlyLivingInTown")
    public Set<User> getUsersLivingIn() {
        return usersLivingIn;
    }

    public void setUsersLivingIn(Set<User> usersLivingIn) {
        this.usersLivingIn = usersLivingIn;
    }
}
