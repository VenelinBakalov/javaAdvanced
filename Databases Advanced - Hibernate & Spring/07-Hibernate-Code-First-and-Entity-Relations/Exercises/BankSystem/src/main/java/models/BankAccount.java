package models;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "bank_accounts")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BankAccount {

    private Long id;
    private String accountNumber;
    private BigDecimal balance;

    public BankAccount() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "account_number")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column(name = "balance")
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void depositMoney(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdrawMoney(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }
}
