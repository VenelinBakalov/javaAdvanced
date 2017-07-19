package models;

import javax.persistence.*;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "credit_cards")
@PrimaryKeyJoinColumn(name = "number")
//@DiscriminatorValue(value = "Credit Card")
public class CreditCard extends BillingDetail {

    private String cardType;
    private int expirationMonth;
    private int expirationYear;

    public CreditCard() {
    }

    @Column(name = "card_type")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Column(name = "expiration_month")
    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @Column(name = "expiration_year")
    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }
}
