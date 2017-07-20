package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by Venelin on 20.7.2017 г..
 */
@Entity
@Table(name = "saving_accounts")
@PrimaryKeyJoinColumn(name = "bank_account_id")
public class SavingAccount extends BankAccount {

    private BigDecimal interestRate;

    public SavingAccount() {
    }

    @Column(name = "interest_rate")
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public void addInterest () {
        super.setBalance(
                super.getBalance().add(
                        super.getBalance().multiply(this.interestRate.divide(BigDecimal.valueOf(100)))
                ));
    }

}
