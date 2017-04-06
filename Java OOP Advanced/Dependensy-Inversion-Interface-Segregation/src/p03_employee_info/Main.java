package p03_employee_info;

public class Main {

    public static void main(String[] args) {
        EmployeeInfoProvider employeeInfo = new EmployeeInfoProvider();
        ConsoleFormatter formatter = new ConsoleFormatter();

        String output = formatter.format(employeeInfo.getEmployeesByName());
        System.out.println(output);
    }
}
