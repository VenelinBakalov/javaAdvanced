package soft.uni.entities;

import soft.uni.entities.api.UserType;
import soft.uni.enums.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Venelin on 27.7.2017 г..
 */
@Entity
@Table(name = "users")
public class User implements UserType {

    private Long id;
    private String email;
    private String password;
    private String fullName;
    private Role role;
    private Set<Game> shoppingCartGames;
    private Set<Game> boughtGames;

    public User() {
        this.shoppingCartGames = new HashSet<>();
        this.boughtGames = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "email", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToMany()
    @JoinTable(name = "users_shopping_cart_games",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
    public Set<Game> getShoppingCartGames() {
        return shoppingCartGames;
    }

    public void setShoppingCartGames(Set<Game> shoppingCartGames) {
        this.shoppingCartGames = shoppingCartGames;
    }

    @ManyToMany
    @JoinTable(name = "users_bought_games",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
    public Set<Game> getBoughtGames() {
        return boughtGames;
    }

    public void setBoughtGames(Set<Game> boughtGames) {
        this.boughtGames = boughtGames;
    }
}
