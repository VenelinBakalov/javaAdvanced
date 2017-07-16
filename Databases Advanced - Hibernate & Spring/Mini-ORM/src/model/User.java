package model;

import persistence.Column;
import persistence.Entity;
import persistence.Id;

import java.time.LocalDate;

/**
 * Created by Venelin on 11.7.2017 г..
 */
@Entity(name = "users")
public final class User {

    @Id
    private long id;

    @Column(name = "first_name")
    private String name;

    private int age;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    public User(String name, int age, LocalDate registrationDate) {
        this.name = name;
        this.age = age;
        this.registrationDate = registrationDate;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
