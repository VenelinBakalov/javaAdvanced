package models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "bank_accounts")
public abstract class BankAccount {

    private Long id;
    private String accountNumber;
    private BigDecimal balance;

    public BankAccount() {
    }
}
