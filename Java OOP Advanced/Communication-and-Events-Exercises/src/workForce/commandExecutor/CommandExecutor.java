package workForce.commandExecutor;

import workForce.annotations.Inject;
import workForce.commandExecutor.commands.Command;
import workForce.repositories.EmployeeRepository;
import workForce.repositories.JobRepository;

import java.lang.reflect.Field;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class CommandExecutor implements Executor {

    private EmployeeRepository employeeRepository;
    private JobRepository jobRepository;

    public CommandExecutor(EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public void executeCommand(Command command) throws IllegalAccessException {
        this.injectDependencies(command);
        command.execute();
    }

    private void injectDependencies(Command command) throws IllegalAccessException {
        Field[] clientFields = command.getClass().getDeclaredFields();
        for (Field clientField : clientFields) {
            if (!clientField.isAnnotationPresent(Inject.class)) {
                continue;
            }
            clientField.setAccessible(true);

            Field[] serviceFields = this.getClass().getDeclaredFields();
            for (Field serviceField : serviceFields) {
                if (!serviceField.getType().equals(clientField.getType())) {
                    continue;
                }
                serviceField.setAccessible(true);

                clientField.set(command, serviceField.get(this));
                break;
            }
        }
    }
}
