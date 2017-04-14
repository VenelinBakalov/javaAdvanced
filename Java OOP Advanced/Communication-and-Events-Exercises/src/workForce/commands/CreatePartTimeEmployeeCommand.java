package workForce.commands;

import workForce.EmployeeRepository;
import workForce.employees.Employee;
import workForce.employees.PartTimeEmployee;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class CreatePartTimeEmployeeCommand extends BaseCommand {

    private EmployeeRepository repository;

    public CreatePartTimeEmployeeCommand(String[] data, EmployeeRepository repository) {
        super(data);
        this.repository = repository;
    }

    @Override
    public void execute() {
        Employee employee = new PartTimeEmployee(super.getData()[1]);
        repository.add(employee);
    }
}
