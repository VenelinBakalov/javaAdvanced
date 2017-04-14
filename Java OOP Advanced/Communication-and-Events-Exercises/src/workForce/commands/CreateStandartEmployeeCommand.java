package workForce.commands;

import workForce.EmployeeRepository;
import workForce.employees.Employee;
import workForce.employees.StandartEmployee;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class CreateStandartEmployeeCommand extends BaseCommand {

    private EmployeeRepository repository;

    public CreateStandartEmployeeCommand(String[] data, EmployeeRepository repository) {
        super(data);
        this.repository = repository;
    }

    @Override
    public void execute() {
        Employee employee = new StandartEmployee(super.getData()[1]);
        this.repository.add(employee);
    }
}
