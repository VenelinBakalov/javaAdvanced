package soft.uni.models.bindingModels.user;

import soft.uni.entities.api.UserType;
import soft.uni.enums.Role;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public class LoggedInUser implements UserType {

    private Long id;
    private String fullName;
    private Role role;

    public LoggedInUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
