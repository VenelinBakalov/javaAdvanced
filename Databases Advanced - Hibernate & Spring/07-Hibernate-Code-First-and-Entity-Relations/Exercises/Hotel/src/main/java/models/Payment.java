package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "payments")
public class Payment {

    private long id;
    private LocalDate paymentDate;
    private Customer customer;
    private LocalDate firstDateOccupied;
    private LocalDate lastDateOccupied;
    private int totalDays;
    private BigDecimal amountCharged;
    private BigDecimal taxRate;
    private BigDecimal taxAmount;
    private BigDecimal payment_total;
    private String notes;

    public Payment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "payment_date")
    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @ManyToOne
    @JoinColumn(name = "account_number", referencedColumnName = "account_number")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "first_date_occupied")
    public LocalDate getFirstDateOccupied() {
        return firstDateOccupied;
    }

    public void setFirstDateOccupied(LocalDate firstDateOccupied) {
        this.firstDateOccupied = firstDateOccupied;
    }

    @Column(name = "last_date_occupied")
    public LocalDate getLastDateOccupied() {
        return lastDateOccupied;
    }

    public void setLastDateOccupied(LocalDate lastDateOccupied) {
        this.lastDateOccupied = lastDateOccupied;
    }

    @Column(name = "total_days")
    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    @Column(name = "amount_charged")
    public BigDecimal getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(BigDecimal amountCharged) {
        this.amountCharged = amountCharged;
    }

    @Column(name = "tax_rate")
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Column(name = "tax_amount")
    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    @Column(name = "payment_total")
    public BigDecimal getPayment_total() {
        return payment_total;
    }

    public void setPayment_total(BigDecimal payment_total) {
        this.payment_total = payment_total;
    }

    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
