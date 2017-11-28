package workForce.commandExecutor.commands;

import workForce.annotations.Inject;
import workForce.employees.Employee;
import workForce.employees.PartTimeEmployee;
import workForce.repositories.EmployeeRepository;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class CreatePartTimeEmployeeCommand extends BaseCommand {

    @Inject private EmployeeRepository repository;

    public CreatePartTimeEmployeeCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        Employee employee = new PartTimeEmployee(super.getData()[1]);
        repository.add(employee);
    }
}
