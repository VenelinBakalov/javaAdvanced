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
@Table(name = "checking_accounts")
@PrimaryKeyJoinColumn(name = "bank_account_id")
public class CheckingAccount extends BankAccount {

    private BigDecimal fee;

    public CheckingAccount() {
    }

    @Column(name = "fee")
    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public void deductFee () {
        super.setBalance(
                super.getBalance().subtract(
                        super.getBalance().multiply(this.fee.divide(BigDecimal.valueOf(100)))
                ));
    }
}
