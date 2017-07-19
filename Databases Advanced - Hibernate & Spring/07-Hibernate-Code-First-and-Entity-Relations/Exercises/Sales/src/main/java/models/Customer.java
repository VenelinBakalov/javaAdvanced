package models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Venelin on 18.7.2017 г..
 */
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic(optional = false)
    private String name;

    @Basic
    private String email;

    @Column(name = "credit_card_number", nullable = false)
    private String creditCardNumber;

    @OneToMany(mappedBy = "customer", targetEntity = Sale.class,
    fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sale> salesForCustomer;

    public Customer() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Set<Sale> getSalesForCustomer() {
        return salesForCustomer;
    }

    public void setSalesForCustomer(Set<Sale> salesForCustomer) {
        this.salesForCustomer = salesForCustomer;
    }
}
