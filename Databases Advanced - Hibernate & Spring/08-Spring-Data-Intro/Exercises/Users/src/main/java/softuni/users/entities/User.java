package softuni.users.entities;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import javax.persistence.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Venelin on 22.7.2017 г..
 */
@Entity
@Table(name = "users")
public class User {

    private Long id;
    private String username;
    private String password;
    private String email;
    private byte[] profilePicture;
    private Date registeredOn;
    private Date lastTimeLoggedIn;
    private Integer age;
    private Boolean isDeleted;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.length() < 4 || username.length() > 30) {
            throw new IllegalArgumentException("Username length be between 4 and 30 symbols.");
        }
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() < 6 || password.length() > 50) {
            throw new IllegalArgumentException("Password length must be between 6 and 50 symbols.");
        }

        Pattern pattern = Pattern.compile("[a-z]");
        Matcher regex = pattern.matcher(password);

        if (!regex.find()) {
            throw new IllegalArgumentException("Password must contain lowercase letter");
        }

        Pattern patternTwo = Pattern.compile("[A-Z]");
        regex = patternTwo.matcher(password);

        if (!regex.find()) {
            throw new IllegalArgumentException("Password must contain uppercase letter");
        }

        Pattern patternThree = Pattern.compile("[0-9]");
        regex = patternThree.matcher(password);

        if (!regex.find()) {
            throw new IllegalArgumentException("Password must contain number");
        }

        Pattern patternFour = Pattern.compile("[!@#$%^&*()_+<>?]");
        regex = patternFour.matcher(password);

        if (!regex.find()) {
            throw new IllegalArgumentException("Password must contain special character");
        }

        this.password = password;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
//        if (!email.matches("^[a-zA-Z0-9]+[\\w.\\-_]+[a-zA-Z0-9]+@[a-zA-Z]+[a-zA-Z.]+[a-zA-Z]+$")) {
        if (!email.matches("^[a-zA-Z0-9]+([\\.\\-_]*[a-zA-Z0-9]+)*@[a-zA-Z]+(\\.[a-zA-Z]+)+$")) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
    }

    @Column(name = "profile_picture", columnDefinition = "LONGBLOB")
    public byte[] getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        if (profilePicture.length > 1024 * 1024) {
            throw new IllegalArgumentException("Picture too big");
        }

        this.profilePicture = profilePicture;
    }

    @Column(name = "registered_on")
    public Date getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    @Column(name = "last_time_logged_in")
    public Date getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(Date lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age < 1 || age > 120) {
            throw new IllegalArgumentException("Age must have value between 1 and 120");
        }
        this.age = age;
    }

    @Column(name = "is_deleted")
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
