package workForce.commandExecutor.commands;

import workForce.annotations.Inject;
import workForce.employees.Employee;
import workForce.employees.StandartEmployee;
import workForce.repositories.EmployeeRepository;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class CreateStandartEmployeeCommand extends BaseCommand {

    @Inject private EmployeeRepository repository;

    public CreateStandartEmployeeCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        Employee employee = new StandartEmployee(super.getData()[1]);
        this.repository.add(employee);
    }
}
