package BankTasks;

public class BankAccount {

    private static final double DEFAULT_INTEREST_RATE = 0.02;

    private static double currentRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = ++bankAccountCount;
    }

    public static void setInterestRate(double rate) {
        currentRate = rate;
    }

    public double getInterest(int years) {
        return this.balance * currentRate * years;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Deposit amount must be non-negative.");
            return;
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient balance");
            return;
        }
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
