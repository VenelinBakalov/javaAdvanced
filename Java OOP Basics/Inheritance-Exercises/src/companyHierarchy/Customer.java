package companyHierarchy;

/**
 * Created by Venelin on 5.3.2017 г..
 */
public class Customer extends Person {

    private Double netPurchaseAmount;

    public Customer(Integer id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.setNetPurchaseAmount(0D);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "netPurchaseAmount=" + netPurchaseAmount +
                '}';
    }

    private void setNetPurchaseAmount(Double amount) {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.netPurchaseAmount = amount;
    }
}
