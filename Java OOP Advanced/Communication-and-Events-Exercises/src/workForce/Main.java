package workForce;

import workForce.commandExecutor.*;
import workForce.commandExecutor.commands.*;
import workForce.jobs.JobEventListener;
import workForce.jobs.Listener;
import workForce.repositories.EmployeeRepository;
import workForce.repositories.JobRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        Listener listener = new JobEventListener();
        JobRepository jobRepository = new JobRepository(listener);
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Executor commandExecutor = new CommandExecutor(employeeRepository, jobRepository);

        while (!"End".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(" ");
            String commandType = commandArgs[0];

            switch (commandType) {
                case "Job":
                    commandExecutor.executeCommand(new CreateJobCommand(commandArgs));
                    break;
                case "StandartEmployee":
                    commandExecutor.executeCommand(new CreateStandartEmployeeCommand(commandArgs));
                    break;
                case "PartTimeEmployee":
                    commandExecutor.executeCommand(new CreatePartTimeEmployeeCommand(commandArgs));
                    break;
                case "Pass":
                    commandExecutor.executeCommand(new PassWeekCommand(commandArgs));
                    break;
                case "Status":
                    commandExecutor.executeCommand(new StatusCommand(commandArgs));
                    break;

            }
        }
    }
}
