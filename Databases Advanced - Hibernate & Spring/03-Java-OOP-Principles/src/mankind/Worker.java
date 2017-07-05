package mankind;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public class Worker extends Human {

    private double weekSalary;
    private double hoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double hoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setHoursPerDay(hoursPerDay);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(super.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ").append(super.getLastName())
                .append(System.lineSeparator())
                .append("Week Salary: ").append(String.format("%.2f", this.getWeekSalary()))
                .append(System.lineSeparator())
                .append("Hours per day: ").append(String.format("%.2f", this.getHoursPerDay()))
                .append(System.lineSeparator())
                .append("Salary per hour: ").append(String.format("%.2f", this.getSalaryPerHour()));

        return sb.toString();
    }

    private double getWeekSalary() {
        return weekSalary;
    }

    private double getHoursPerDay() {
        return hoursPerDay;
    }

    private double getSalaryPerHour() {
        return this.getWeekSalary() / (7 * this.getHoursPerDay());
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }

        this.weekSalary = weekSalary;
    }

    private void setHoursPerDay(double hoursPerDay) {
        if (hoursPerDay < 1 || 12 < hoursPerDay) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }

        this.hoursPerDay = hoursPerDay;
    }
}
