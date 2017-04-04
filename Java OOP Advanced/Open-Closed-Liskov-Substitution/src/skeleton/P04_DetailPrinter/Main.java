package skeleton.P04_DetailPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 4.4.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Pesho"));
        employees.add(new Employee("Venci"));
        employees.add(new Manager("Ivan", "Docs"));
        employees.add(new Worker("Venci", 1));
        DetailsPrinter printer = new DetailsPrinter(employees);
        printer.printDetails();
    }
}
