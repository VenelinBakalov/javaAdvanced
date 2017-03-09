package app.people;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class Person {

    private double income;

    public Person(double income) {
        this.setIncome(income);
    }

    public double getIncome() {
        return this.income;
    }

    private void setIncome(double income) {
        this.income = income;
    }
}
