package models;

import javax.persistence.*;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "bank_accounts")
@PrimaryKeyJoinColumn(name = "number")
//@DiscriminatorValue(value = "Bank Account")
public class BankAccount extends BillingDetail {

    private String bankName;
    private String SWIFTCode;

    public BankAccount() {
    }

    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Column(name = "swift_code")
    public String getSWIFTCode() {
        return SWIFTCode;
    }

    public void setSWIFTCode(String SWIFTCode) {
        this.SWIFTCode = SWIFTCode;
    }
}
