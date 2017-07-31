package soft.uni.models.bindingModels.user;

import soft.uni.entities.api.UserType;
import soft.uni.validators.Email;
import soft.uni.validators.Password;
import soft.uni.validators.PasswordMatching;

/**
 * Created by Venelin on 27.7.2017 г..
 */
@PasswordMatching
public class RegisterUser implements UserType {

    //    @Pattern(regexp = ".+[@.]+.+", message = "Invalid email")
    @Email
    private String email;
    @Password
    private String password;
    private String confirmPassword;
    private String fullName;

    public RegisterUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
